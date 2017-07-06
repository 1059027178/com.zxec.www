package com.webChatServer.action;

import com.opensymphony.xwork2.ActionSupport;
import com.webChatServer.model.Category;
import com.webChatServer.server.iface.CategoryService;

public class CategoryAction extends ActionSupport{
	//����categoryService��Ϊ�˺�ֱ�۵Ŀ�����Spring����ǰ��Ĳ�ͬ  
	private CategoryService categoryService;
	//����һ��˽�г�Ա��������url�������Ĳ�����ע������Ҫд��get��set����  
	private Category category;
	
	public void setCategoryServer(CategoryService categoryService){
		this.categoryService = categoryService;
	}
	
	public String update(){
		System.out.println("****update****");
		//����ǰ�������ͬ  
		System.out.println(categoryService);//�����Ѿ���Spring���ϣ����Կ����õ����categoryService�ˣ���ӡ�����Ͳ���null��  
		categoryService.update(category);//�¼�һ����䣬���������ݿ�  
		return "index";
	}
	
	public String save(){
		System.out.println("****save****");
		//����ǰ�������ͬ  
		System.out.println(categoryService);//�����Ѿ���Spring���ϣ����Կ����õ����categoryService�ˣ���ӡ�����Ͳ���null��  
		categoryService.save(category);//�¼�һ����䣬���������ݿ�  
		return "index";
		
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}



