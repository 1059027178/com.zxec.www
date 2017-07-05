package com.webChatServer.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webChatServer.model.Category;
import com.webChatServer.server.iface.CategoryService;
import com.webChatServer.server.impl.CategoryServiceImpl;



/** 
 * @Description TODO(采用Spring的注解调试，仅仅支持Spring3.1及以上) 
 * @author Qian Yang 
 * @since 2017年6月30日
 */  
/* 
 * Spring3.1后多了个spring-test-4.2.4.RELEASE.jar包，这个jar包专门用来支持JUnit基于注解的测试的，
 * 该jar包在spring-4.2.4-core中  该jar包里有个SpringJUnit4ClassRunner.class，用@RunWith注解加进来即可 
 * 注解@ContextConfiguration表示将ApplicationContext对象注入进来，就不用像以往那样在测试程序里先new了，直接使用 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class TestSSHConfig {
	@Resource
	private Date date;
	//*****************测试Spring IOC的开发环境  
	@Test
	public void springIOC(){
		System.out.println(date);
	}
/**【测试Hibernate的开发环境，因为没有整合，可以直接new】**/
	/*@Test
	public void hibernate(){
		CategoryService categoryService = new CategoryServiceImpl();
		Category category = new Category(2,"服装2", 1);
		categoryService.save(category);
	}*/
	
/**【测试Hibernate与spring的整合】**/
	@Resource
	private CategoryService categoryService;
	
	@Test
	public void hibernateAndSpringNew(){
		categoryService.save(new Category("服装1", 1));
	}
	
	@Test
	public void hibernateAndSpring(){
		categoryService.update(new Category(10,"裙子", 0));
	}
}













