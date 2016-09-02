package com.thinkway.cms.presentation.web.controller.fix;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TimestampEditor extends PropertyEditorSupport {
	public void setAsText(String text) throws IllegalArgumentException {
		Timestamp value = null;
		if (null != text && !text.equals("")) {
			value = Timestamp.valueOf(text+" 00:00:00.000000000");
		}
		
		setValue(value);
	}

	public String getAsText() {
		SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd");
		if(null != getValue()){
			Timestamp value = (Timestamp) getValue();
			return sdf.format(value).toString();
		}
		else{
			
	        Date now = new Date();
	        String curDate = sdf.format(now).toString();
	        return curDate;
		}
			
	}
} 

