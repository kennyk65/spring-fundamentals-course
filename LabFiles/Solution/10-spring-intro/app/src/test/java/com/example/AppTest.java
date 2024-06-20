package com.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class AppTest {

    static Greeting greetingBean;

    @BeforeAll
    static void setup() {
        ApplicationContext spring = 
            new AnnotationConfigApplicationContext(Config.class);
        greetingBean = spring.getBean(Greeting.class);        
    }


    @Test 
    void testGreeting() {
        Assertions.assertThat(
            greetingBean.getGreeting()).isEqualTo("Hello World!");
    }
}
