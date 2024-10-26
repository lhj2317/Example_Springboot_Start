package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.Valid;

@Controller
public class MyController {

    @RequestMapping("/")
    public @ResponseBody String root() throws Exception{
        return "Valid_Annotation (4)";
    }

    @RequestMapping("/insertForm")
    public String insert1() {

        return "createPage";       
    }
     
    @RequestMapping("/create")
    public String insert2(@ModelAttribute("dto") @Valid ContentDto contentDto,
                          BindingResult result)
    {
        String page = "createDonePage";
        System.out.println(contentDto);
        
        // 유효성검사가 필요할때마다 36라인에서처럼 생성을 하고 37라인에서 유효성 검사멧드를 호출하는것이 아니고  
        // 28라인에서 보이는 것처럼 유효성검사가 필요한 객체 변수에 @Valid 어노테이션만 붙여주면 간단하게 휴효성검사를 수항하게 된다.
//        ContentValidator validator = new ContentValidator();
//        validator.validate(contentDto, result);
        if (result.hasErrors()) {      	
//        	if (result.getFieldError("writer")!= null) {
//        		System.out.println("1:"+result.getFieldError("writer").getCode());
//        	}
//        	if (result.getFieldError("content")!= null) {
//        		System.out.println("2:"+result.getFieldError("content").getCode());
//        	}
	        if (result.getFieldError("writer")!= null) {
	    		System.out.println("1:"+result.getFieldError("writer").getDefaultMessage());
	    	}
	    	if (result.getFieldError("content")!= null) {
	    		System.out.println("2:"+result.getFieldError("content").getDefaultMessage());
	    	}
	        	
	        page = "createPage";
	    }
        
        return page;       
    }
    
//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//    	binder.setValidator(new ContentValidator());
//    }
}
