package com.webChatServer.action;

import com.opensymphony.xwork2.ActionSupport;
import com.webChatServer.server.iface.CategoryService;

public class CategoryAction extends ActionSupport{
	//����categoryService��Ϊ�˺�ֱ�۵Ŀ�����Spring����ǰ��Ĳ�ͬ  
	private CategoryService categoryService;
	
	public void setCategoryServer(CategoryService categoryService){
		this.categoryService = categoryService;
	}
	
	public String update(){
		System.out.println("****update****");
		//����ǰ�������ͬ  
		System.out.println(categoryService);
		return "index";
	}
	
	public String save(){
		System.out.println("****save****");
		//����ǰ�������ͬ  
		System.out.println(categoryService);
		return "index";
		
	}
}



