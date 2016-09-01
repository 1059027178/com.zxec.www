package com.thinkway.cms.presentation.web.controller.fix;

import java.beans.PropertyEditorSupport;


public class IntegerEditor extends PropertyEditorSupport {
	public void setAsText(String text) throws IllegalArgumentException {
		Integer value = null;
		if (null != text && !text.equals("")) {
			value = Integer.valueOf(text);
		}
		
		setValue(value);
	}

	public String getAsText() {

		if(null != getValue()){
			
			Integer value = (Integer) getValue();
			return value.toString();
		}
		else
			return "0";
	}
} 

