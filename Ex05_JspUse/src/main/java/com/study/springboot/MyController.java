package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception {
		return "JSP in Gradle";		
	}
	
	@RequestMapping("/test1")  // localhost:8081/test1
	public String test1() {   
		return "test1";		   // 실제 호출 될  /WEB-INF/views/test1.jsp 
	}
	
	@RequestMapping("/test2")  // localhost:8081/test2
	public String test2() {   
		return "/sub/test2";		   // 실제 호출 될  /WEB-INF/views/test2.jsp 
	}

}
