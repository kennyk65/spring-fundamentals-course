package com.example.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Config;

//  TODO-02:  Refactor this test class to use Spring's test framework.
//  Add an annotation to this class to make it a Spring test class.
//  Be sure to include the configuration class you wish to load.
//  Remove the @BeforeAll method.
//  Make the Register variable non-static.  
//  Use an annotation to automatically populate it when the test starts.
//  Organize your imports.  Run the test.  It should pass.

class RegisterTest {

    private static Register register;
    
    @BeforeAll
    static void setup() {
        ApplicationContext spring = 
            new AnnotationConfigApplicationContext(Config.class);
        register = spring.getBean(Register.class);        
    }

    @Test 
    void testRegister() {
        double result = register.computeTotal(100);
        Assertions.assertThat(result).isEqualTo(100.00 + 6.00);
        System.out.println(String.format("The computed total including tax is: %.2f", result));
    }

}
