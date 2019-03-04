package com.sda.java.emag;

import com.sda.java.emag.item.Item;

public class User implements Runnable{             // Runnable forteaza implementarea metodei run

    // try to get specified amount of items and the item itself, or stop after 5s

    public User(CartController cartController, Item item, int quantity) {
        this.cartController = cartController;
        this.item = item;
        this.quantity = quantity;
    }
    private static final int MILLISECONDS_TO_SECONDS_RATIO = 1000;
    private final CartController cartController;
    private final Item item;
    private final int quantity;
    private int counter;

    public int getCounter() {
        return counter;
    }

    private int getElapsedTimeInSeconds(long startTime) {
        return new Long((System.currentTimeMillis() - startTime) / MILLISECONDS_TO_SECONDS_RATIO).intValue();
    }

@Override
    public void run(){

        counter =0;
        final long startTime=System.currentTimeMillis();
        while (counter<quantity&& (getElapsedTimeInSeconds(startTime)<5)) {
            counter += cartController.addItemToCart(item, 1);
        }

    }



}
