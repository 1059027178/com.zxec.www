package com.webChatServer.action;

import com.opensymphony.xwork2.ActionSupport;
import com.webChatServer.server.iface.CategoryService;

public class CategoryAction extends ActionSupport{
	//设置categoryService是为了很直观的看出与Spring整合前后的不同  
	private CategoryService categoryService;
	
	public void setCategoryServer(CategoryService categoryService){
		this.categoryService = categoryService;
	}
	
	public String update(){
		System.out.println("****update****");
		//整合前后输出不同  
		System.out.println(categoryService);
		return "index";
	}
	
	public String save(){
		System.out.println("****save****");
		//整合前后输出不同  
		System.out.println(categoryService);
		return "index";
		
	}
}



