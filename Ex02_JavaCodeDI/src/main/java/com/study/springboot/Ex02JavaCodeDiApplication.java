package com.study.springboot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.study.springboot.bean.Config;
import com.study.springboot.bean.Member;
import com.study.springboot.bean.Printer;

//@SpringBootApplication
public class Ex02JavaCodeDiApplication {

    public static void main(String[] args) {
        //SpringApplication.run(Ex02JavaCodeDiApplication.class, args);

        // 1.IoC 컨테이너 생성
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // 2.Member Bean 가져오기
        Member member1 = (Member)context.getBean("member1");
        member1.print();
    
        // 3.Member Bean 가져오기
        Member member2 = context.getBean("hello", Member.class);
        member2.print();
    
        // 4.PrinterB Bean 가져오기 
        Printer printer = context.getBean("printerB", Printer.class);
        member1.setPrinter(printer);
        member1.print();

        // 5.싱글톤인지 확인
        if (member1 == member2) {
            System.out.println("동일한 객체입니다.");
        } else {
            System.out.println("서로 다른 객체입니다.");
        }

    }

}
