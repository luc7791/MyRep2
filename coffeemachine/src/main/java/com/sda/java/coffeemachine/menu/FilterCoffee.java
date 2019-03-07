package com.sda.java.coffeemachine.menu;

import com.sda.java.coffeemachine.CoffeeType;

public class FilterCoffee extends Coffee{
    private static final CoffeeType FilterCoffee = CoffeeType.FilterCoffee;
    public FilterCoffee(){
        super(CoffeeType.FilterCoffee);
    }

    protected String getCoffeeName(){
        return CoffeeType.FilterCoffee.toString();
    }
}
