package cn.webChatServer.action;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping(value="centerTest")
public class CenterActionTest {
	@Autowired
	private org.springframework.web.context.WebApplicationContext context;
	private MockMvc mockMvc;

	@Before
	public void before() {
		// 可以对所有的controller来进行测试
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		// 仅仅对单个Controller来进行测试
		// mockMvc = MockMvcBuilders.standaloneSetup(new
		// MeunController()).build();
	}

	@Test
	public void testIndex() {
		 System.out.println("----------------------------");
//         ResultActions actions = this.mockMvc.perform(get("/menu/manage.action"));
//         System.out.println(status());//
//         System.out.println(content().toString());
//         actions.andExpect(status().isOk());
//         actions.andExpect(content().contentType("text/html"));

         System.out.println("----------------------------");
	}

	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testReportWork() {
		fail("Not yet implemented");
	}

	@Test
	public void testMyYield() {
		fail("Not yet implemented");
	}

	@Test
	public void testMySalary() {
		fail("Not yet implemented");
	}

}
