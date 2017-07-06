package com.webChatServer.action;

import com.opensymphony.xwork2.ActionSupport;
import com.webChatServer.model.Category;
import com.webChatServer.server.iface.CategoryService;

public class CategoryAction extends ActionSupport{
	//设置categoryService是为了很直观的看出与Spring整合前后的不同  
	private CategoryService categoryService;
	//设置一个私有成员变量接收url带过来的参数，注意下面要写好get和set方法  
	private Category category;
	
	public void setCategoryServer(CategoryService categoryService){
		this.categoryService = categoryService;
	}
	
	public String update(){
		System.out.println("****update****");
		//整合前后输出不同  
		System.out.println(categoryService);//由于已经和Spring整合，所以可以拿到这个categoryService了，打印出来就不是null了  
		categoryService.update(category);//新加一条语句，来更新数据库  
		return "index";
	}
	
	public String save(){
		System.out.println("****save****");
		//整合前后输出不同  
		System.out.println(categoryService);//由于已经和Spring整合，所以可以拿到这个categoryService了，打印出来就不是null了  
		categoryService.save(category);//新加一条语句，来更新数据库  
		return "index";
		
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}



