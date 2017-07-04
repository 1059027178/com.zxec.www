package com.webChatServer.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webChatServer.model.Category;
import com.webChatServer.server.iface.CategoryService;
import com.webChatServer.server.impl.CategoryServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class TestHibernateConfig {
	//测试Hibernate的开发环境，因为没有整合，可以直接new  
	@Test
	public void hibernate(){
		CategoryService categoryService = new CategoryServiceImpl();
		Category category = new Category("男士运动服", 1);
		categoryService.save(category);
	}
}
