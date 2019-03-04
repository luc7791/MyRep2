package com.sda.java.emag;

import com.sda.java.emag.businessLogic.Cart;
import com.sda.java.emag.businessLogic.Stock;
import com.sda.java.emag.item.Item;
import java.util.LinkedHashMap;
import java.util.Map;

public class CartController {
    // provide an User the methods for updating his cart from a stock or list of stocks. It will contain an instance of  Cart and an instance of at least one Stock
    // Methods: addItemToCart(),removeItemFromCart(),removeAllCartItems

    private final Cart cart = new Cart (new LinkedHashMap<>());               //linkedHashMap: tine obiectele in ordinea inserarii
    private final Stock stock;                                   // final forteaza initializarea sau sa facem constructor

    public CartController(Stock stock) {
        this.stock = stock;
    }

    public int addItemToCart(Item item, int quantity){
            int retrieveStockItems =stock.retrieveItem(item,quantity);
        return cart.addCartItem(item,retrieveStockItems);
    }

    public int removeItemFromCart(Item item,int quantity){
        int removeItemsfromCart= cart.removeItem(item,quantity);
        return stock.addItem(item,quantity);

    }
     public int removeAllItemsFromCart() {

         final Map<Item, Integer> removedAllItems = cart.removeAll();
         for (Map.Entry<Item, Integer> itemEntry : removedAllItems.entrySet()) {
             stock.addItem(itemEntry.getKey(),itemEntry.getValue());
         }
         return removedAllItems.entrySet().size();
     }

}
