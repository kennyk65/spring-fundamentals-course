/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.service.Register;

public class App {

    public static void main(String[] args) {
        ApplicationContext spring =  
            new AnnotationConfigApplicationContext(Config.class);
        Register register = spring.getBean(Register.class);
        double total = register.computeTotal(100.00);
        System.out.println("Total: " + total);
    }
}
