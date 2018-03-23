package board.controllers;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
	private Map<String, Object> model = new HashMap<>();
	private String viewName;
	
	public ModelAndView() {}
	public ModelAndView(String viewName) {
		this.viewName = viewName;
	}
	public ModelAndView(String viewName, String key, Object value) {
		this.viewName = viewName;
		addObject(key,  value);
	}
	
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	
	public void addObject(String key, Object value) {
		model.put(key,  value);
	}
	
	public Map<String, Object> getModel() {
		return model;
	}
	public String getViewName() {
		return viewName;
	}

}
