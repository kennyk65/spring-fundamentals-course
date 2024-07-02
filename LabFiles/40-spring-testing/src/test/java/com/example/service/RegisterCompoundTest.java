package com.example.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Config;

//  TODO-03:  Refactor this test class to use Spring's test framework.
//  Add an annotation to this class to make it a Spring test class.
//  Include the configuration class you wish to load.
//  Add an annotation to activate the "compound" profile.
//  Remove the @BeforeAll method.
//  Make the Register variable non-static.  
//  Use an annotation to automatically populate it when the test starts.
//  Organize your imports.  Run the test.  It should pass.

public class RegisterCompoundTest {

    private static Register register;
    
    @BeforeAll
    static void setup() {
        System.setProperty("spring.profiles.active", "compound");
        ApplicationContext spring = 
            new AnnotationConfigApplicationContext(Config.class);
        register = spring.getBean(Register.class);        
    }

    @Test 
    void testRegister() {
        double result = register.computeTotal(100);
        Assertions.assertThat(result).isEqualTo(100.00 + 8.50);
        // Assertions.assertThat(result).isEqualTo(100.00 + 7.0);
        System.out.println(String.format("The computed total including tax is: %.2f", result));
    }


//  TODO-04:  (OPTIONAL) Without modifying app.properties, change the 
//  tax.rate and local.tax.rate properties used by this test to 0.03 and 0.04 respectively.
//  Modify the code in the testRegister() method to expect a result of 100.00 + 7.
//  Run the test.  It should pass.


}
