package cn.webChatServer.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.webChatServer.pojo.TestTb;
import cn.webChatServer.service.TestTbService;

@Controller
public class CenterAction {
	@Autowired
	private TestTbService testTbService;
	
	@RequestMapping(value="/test/index.do")
	public String index(Model model)
	{
		TestTb tb = new TestTb();
		tb.setId(8);
		tb.setName("曹操");
		System.out.println("haha");
		testTbService.add(tb);
		return "index";
	}

}
