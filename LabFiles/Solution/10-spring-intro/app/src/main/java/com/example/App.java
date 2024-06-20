package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext spring = 
            new AnnotationConfigApplicationContext(Config.class);

        Greeting greetingBean = spring.getBean(Greeting.class);        
        System.out.println(greetingBean.getGreeting());
    }
}
