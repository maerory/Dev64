package board.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet("/article/*")
public class DispatcherServlet extends HttpServlet {
	
	private static Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
	private Map<String, AbstractController> controllerMap = 
			new HashMap<String, AbstractController>();
	
	
    @Override
    public void init() throws ServletException {
    	Properties pr = new Properties();
    	String fileName = this.getClass().getResource("").getPath() 
    			+ "dispatcher-servlet.properties";
    	try { //Seperate try-catch for two methods to give distinct error messages
			pr.load(new FileInputStream(fileName));
			for (Object obj : pr.keySet()) {
				String key = ((String) obj).trim();
				String classPath = pr.getProperty(key);
				try {
					Class className = Class.forName(classPath); //Select the appropriate classname saved on the property to add more flexibility
					className.newInstance();
					controllerMap.put(key, (AbstractController) className.newInstance());
					logger.info("loaded : " + key);
				} catch (Exception e) {
					logger.info("failure : " + key);
				}
			}
    	} catch(Exception e) {
    		logger.info("Cannot find dispatcher-servlet.properties");
    		return;
    	}
    }
    
    
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		logger.info("DispatcherServlet.service() Online..");
		
		String action = request.getRequestURI().substring(
				request.getContextPath().length());
		ModelAndView mav = null;
		AbstractController controller = null;
		controller = controllerMap.get(action);
		if (controller == null) { //controller action does not match due to some typo?
			logger.info("action not in properties");
			return;
		}
		// Fetch the appropriate MAV view for the requested page
		mav = controller.handleRequestInternal(request, response);
	
		if (mav != null) {
			for (String key : mav.getModel().keySet()) {
				request.setAttribute(key, mav.getModel().get(key));
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(mav.getViewName());
			dispatcher.forward(request,  response);
			return;
		} else {	
			logger.info("DispatcherServlet Lost...");
		}
		
	}

}
