package com.sda.java.emag;
import com.sda.java.emag.item.Item;

public class User implements Runnable{             // Runnable forteaza implementarea metodei run

    // try to get specified amount of items and the requestedItem itself, or stop after 5s

    public User(CartController cartController, Item requestedItem, int requestedQuantity) {
        this.cartController = cartController;
        this.requestedItem = requestedItem;
        this.requestedQuantity = requestedQuantity;
    }
    private static final int MILLISECONDS_TO_SECONDS_RATIO = 1000;
    private final CartController cartController;
    private final Item requestedItem;
    private final int requestedQuantity;
    private int retrievedItemQuantity;

    public int getRetrievedItemQuantity() {
        return retrievedItemQuantity;
    }

    private int getElapsedTimeInSeconds(long startTime) {                   // carlculeaza cate milisec au trecut de la current time
        return new Long((System.currentTimeMillis() - startTime) / MILLISECONDS_TO_SECONDS_RATIO).intValue();
    }

@Override
    public void run(){

        retrievedItemQuantity =0;
        final long startTime=System.currentTimeMillis();            // intoarce timpul in milisec (contorizare din 1970)
        while (retrievedItemQuantity < requestedQuantity && (getElapsedTimeInSeconds(startTime)<5)) {
            retrievedItemQuantity += cartController.addItemToCart(requestedItem, 1);
        }
    }


}
