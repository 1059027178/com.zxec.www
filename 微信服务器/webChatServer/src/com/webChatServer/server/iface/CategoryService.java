package com.webChatServer.server.iface;

import com.webChatServer.model.Category;

public interface CategoryService {
	public void save(Category category); //��������Hibernate����  
	public void update(Category category);//����hibernate + spring ���Ϻ��Ч��
}
