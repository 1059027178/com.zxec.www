package com.webChatServer.server.iface;

import com.webChatServer.model.Category;

public interface CategoryService {
	public void save(Category category); //用来测试Hibernate环境  
	public void update(Category category);//测试hibernate + spring 整合后的效果
}
