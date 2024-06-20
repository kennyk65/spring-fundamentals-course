package com.example.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.dao.PurchaseDao;
import com.example.domain.Customer;
import com.example.domain.Purchase;

//  TODO-21: (OPTIONAL) Annotate this class as a Mockito test class.
//  You will need to use the JUnit @ExtendWith annotation combined with the MockitoExtension class.
//  This unit test will use Java, JUnit, Mockito, and AssertJ.  It will not use Spring at all.
@ExtendWith(MockitoExtension.class)
public class PurchaseServiceImplTests {

    //	TODO-22: (OPTIONAL) Define a variable called purchaseDao of type PurchaseDao.
    //  Annotate this variable with @Mock.
    @Mock PurchaseDao purchaseDao;              

    //  TODO-23: (OPTIONAL) Define a variable called purchaseService of type PurchaseServiceImpl.
    //  Annotate this variable with @InjectMocks.  This tells Mockito to inject it with the mock purchaseDao.
    @InjectMocks    PurchaseServiceImpl purchaseService;  
    
    @Test
    public void testFindAllPurchases() {
        List<Purchase> expectedPurchases = expectedPurchases();

        //  TODO-24: (OPTIONAL) Use Mockito's when() method to program the mock.
        //  When the mock's getAllPurchases() method is called, then have it return expectedPurchases.
        when(
            purchaseDao.getAllPurchases())
            .thenReturn(expectedPurchases);
        
        //  TODO-25: (OPTIONAL) Call the method under test.
        //  Capture the results of the findAllPurchases() method in a variable.
        List<Purchase> result =
            purchaseService.findAllPurchases();
        
        //  TODO-26: (OPTIONAL) Test the result.
        //  Assert that the returned result contains the same elements in the expectedPurchase list.
        assertThat(result)
            .containsExactlyElementsOf(expectedPurchases);        
        
        //  TODO-27: (OPTIONAL) Verify that the mock had its getAllPurchases() method called.
        //  Hint: use the verify() method.  Your mock object is the parameter to this method.
        verify(purchaseDao).getAllPurchases();
    }

    //  TODO-28: (OPTIONAL) Organize all imports, save all work.  Run this test, it should pass


    //  Sample test data:
    private List<Purchase> expectedPurchases() {
        Customer srinivas = new Customer(5, "Srinivas", "srini@cool.com");
        return  List.of(
            new Purchase(1, srinivas, new Date(), "lava lamp"),
            new Purchase(2, srinivas, new Date(), "badmitton set"),
            new Purchase(3, srinivas, new Date(), "parachute retainer clip"),
            new Purchase(4, srinivas, new Date(), "scuba regulator")
        );
    }


}
