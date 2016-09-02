package com.thinkway.cms.presentation.web.controller.fix;

import java.beans.PropertyEditorSupport;


public class DoubleEditor extends PropertyEditorSupport {
	public void setAsText(String text) throws IllegalArgumentException {
		Double value = null;
		if (null != text && !text.equals("")) {
			value = Double.valueOf(text);
		}
		
		setValue(value);
	}

	public String getAsText() {

		if(null != getValue()){
			
			Double value = (Double) getValue();
			return value.toString();
		}
		else
			return "0";
	}
} 

