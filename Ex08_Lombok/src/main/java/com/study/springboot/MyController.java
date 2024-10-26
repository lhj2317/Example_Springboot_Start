package com.study.springboot;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {

    @RequestMapping("/")
    public @ResponseBody String root() throws Exception{
        return "Lombok 사용하기";
    }
     
    @RequestMapping("/test3")
    public String test3(Member member, Model model)
    {
    	// 파라미터와 일치하는 빈을 만들어서 사용할 수 있다.
    	// View 페이지에서 model 을 사용하지 않고 member를 사용한다.
        return "test3";       
    }

}
