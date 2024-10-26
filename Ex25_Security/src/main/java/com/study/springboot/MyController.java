package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping("/")
    public @ResponseBody String root() throws Exception{
        return "Security (1)";
    }

    @RequestMapping("/guest/welcome")
    public String welcone1() {
    	
        return "guest/welcome1";        
    }
    
    @RequestMapping("/member/welcome")
    public String welcone2() {
    	
        return "member/welcome2";        
    }
    
    @RequestMapping("/admin/welcome")
    public String welcone3() {
    	
        return "admin/welcome3";        
    }

}