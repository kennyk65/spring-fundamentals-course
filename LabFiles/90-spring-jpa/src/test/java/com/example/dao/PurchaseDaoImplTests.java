package com.example.dao;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.domain.Customer;
import com.example.domain.Purchase;

import jakarta.persistence.EntityManager;

//	TODO-14: Annotate this class to make it a Spring test class.
//  Include the configuration class you wish to load.
//  Make the test Transactional, be sure to import the org.springframework.transaction.annotation.Transactional class.

public class PurchaseDaoImplTests {
    
    //  TODO-15: Use @PersistenceContext to inject the EntityManager into this class.
    EntityManager em;
    
    //  TODO-16: Inject the PurchaseDao into this class.
    PurchaseDao repo;


    //  TODO-17: Examine the test logic in the following method.
    //  It retrieves all purchases, then asserts that there are multiple purchases.
    //  It also asserts that the first purchase has its properties mapped;
    //  This verifies that the JPA mapping metadata is correct.
    //  Notice that customer name is accessed on the Customer referenced through the Purchase object.
    //  Remove the @Disabled annotation.  Run this test, it should pass.
    @Test
    @Disabled
    public void	findAllPurchases() {
        List<Purchase> purchases = repo.getAllPurchases();

        //  Make sure there are multiple purchases, and 
        //  that purchases have their properties mapped:
        assertThat(purchases).isNotNull();
        assertThat(purchases.size()).isGreaterThan(0);
        Purchase p = purchases.get(0);
        assertThat(p).isNotNull();
        assertThat(p.getId()).isNotNull();
        assertThat(p.getCustomer().getName()).isNotNull();
        assertThat(p.getCustomer().getName()).isEqualTo("Bruce");
    }

    //  TODO-18: Implement the getPurchase() test method.
    //  This method should retrieve a single purchase by its id.
    //  Use an ID value of 1, 2, or 3 to match the data in data.sql
    //  Make sure the purchase has its properties mapped.  
    //  Use the method above for guidance.
    @Test
    public void	getPurchase() {

    }

    //  TODO-19: Implement the savePurchase() test method.
    //  Alter the Purchase test data as you like, and call the savePurchase() method.
    //  After saving, clear the persistence context by calling 'em.clear()'
    //  Retrieve the purchase you just saved by calling getPurchase(String customerName, Date date)
    //  Add assertions to make sure the purchase was saved properly.
    //  Remove the @Disabled annotation.
    @Test
    @Disabled
    public void testSaveAndFind() {

        //  Get an existing customer:
        Customer c = em.find(Customer.class, 1);

        //  Create a new purchase:
        Purchase p = new Purchase();
        p.setCustomer(c);
        p.setProduct("Incan ceremonial headmask");
        p.setPurchaseDate(new Date());

        //  Save...
    
        //  Clear...
    
        //  Find...
    
        //  Assert...
    
    }

    //  TODO-20: Organize all imports, save all work.  Run this test, it should pass
}
