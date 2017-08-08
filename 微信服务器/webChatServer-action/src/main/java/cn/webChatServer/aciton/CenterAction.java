package cn.webChatServer.aciton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.webChatServer.TestTbService;
import cn.webChatServer.pojo.TestTb;

@Controller
public class CenterAction {
	
	@Autowired
	private TestTbService testTbService;
	
	@RequestMapping(value="/test/index.do")
	public String index(Model model){
		
		TestTb testTb = new TestTb();
		testTb.setId(6);
		testTb.setName("老夫子1");
		testTbService.add(testTb);
		System.out.println("呵呵");
		
		return "index";
	}
}
