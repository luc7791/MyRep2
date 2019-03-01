package com.sda.java.emag;

import com.sda.java.emag.businessLogic.Cart;
import com.sda.java.emag.businessLogic.Stock;
import com.sda.java.emag.item.Phone;
import com.sda.java.emag.item.Shoes;

import java.io.IOException;
import java.util.HashMap;

public class ApplicationEmag {

    private static final String PHONE_NAME = "X";
    private static final float PRICE = 1000f;       //se pune f la final sa nu se incurce float cu double
    private static final String BRAND = "IOS";
    private static final float DISPLAY_SIZE = 5.5f;
    private static final String CPU = "A10";
    private static final float COMPARE_DOUBLE_DELTA = 0.01f;
    private static final String brand = "Nike";
    private static final Integer size = 24;
    private static final String color = "blue";

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        final Stock baneasaMall = new Stock(new HashMap<>());
        final Phone iphoneX = new Phone(PHONE_NAME, PRICE, BRAND, DISPLAY_SIZE, CPU);

        final int supply_quantity = 5;
        final int consume_quantity=2;
        final int currentIphoneStock=baneasaMall.addItem(iphoneX,supply_quantity);
        final Shoes nike = new Shoes("nike",PRICE,brand,size,color);
        final String showStock1=baneasaMall.showItems();
        final Cart cart = new Cart(new HashMap<>());

        int retrieveIphoneQuantity=baneasaMall.retrieveItem(iphoneX, consume_quantity);
        System.out.println("Initially Iphone X stock quantity is "+ currentIphoneStock);
        System.out.println("Remained iphone x quantity is " + retrieveIphoneQuantity);
        retrieveIphoneQuantity=baneasaMall.retrieveItem(iphoneX, consume_quantity);
        System.out.println("Remained (2)  iphone x quantity is " + retrieveIphoneQuantity);
        retrieveIphoneQuantity=baneasaMall.retrieveItem(iphoneX, consume_quantity);
        System.out.println("Remained (3)iphone x quantity is " + retrieveIphoneQuantity);

        System.out.println(cart.getCurrentItems());

        cart.addCartItem(iphoneX,20);
        cart.addCartItem(nike,100);
        cart.print();
//        baneasaMall.saveState();
        baneasaMall.loadState();

    }

}
