package com.sda.java.emag.item;

import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneTest {

    private static final String PHONE_NAME = "X";
    private static final float PRICE = 1000f;       //se pune f la final sa nu se incurce float cu double
    private static final String BRAND = "IOS";
    private static final float DISPLAY_SIZE = 5.5f;
    private static final String CPU = "A10";
    private static final float COMPARE_DOUBLE_DELTA = 0.01f;


    @Test

    public void itCreatesAPhone(){

        //Given

        //When

        Item iphone= new Phone(PHONE_NAME, PRICE, BRAND, DISPLAY_SIZE, CPU);
        //Then
        assertNotNull(iphone); // e ok daca are valori (nu e null)
        assertEquals(PHONE_NAME, iphone.getName());
        assertNotEquals(900f,iphone.getPrice());
       assertEquals(DISPLAY_SIZE, ((Phone) iphone).getDisplay_size(),COMPARE_DOUBLE_DELTA); // cand avem de comparat float trebuie sa punem si marja de 0.01 + f daca e float
        assertEquals(PRICE,iphone.getPrice(),0.01f);
        assertEquals(Phone.CATEGORY,iphone.getCategory());


    }


}
