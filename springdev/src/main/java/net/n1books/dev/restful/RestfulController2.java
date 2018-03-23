package net.n1books.dev.restful;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("restful2")
public class RestfulController2 {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(RestfulController2.class);
	
	@RequestMapping(value="form")
	public void form() {}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public void doGet(String name, int age) {
		logger.info("doGet() 수행중... : " + name + "," + age);
		
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public void doPost(String name, int age) {
		logger.info("doPost() 수행중... : " + name + "," + age);
	}
	
	@RequestMapping(value="/", method=RequestMethod.PUT)
	public void doPut(String name, int age) {
		logger.info("doPut() 수행중... : " + name + "," + age);
	}
	
	@RequestMapping(value="/", method=RequestMethod.DELETE)
	public void doDelete(String name, int age) {
		logger.info("doDelete() 수행중... : " + name + "," + age);
	}
	
}
