package com.sda.java.coffeemachine.menu;

import com.sda.java.coffeemachine.CoffeeType;

public class Latte extends Coffee{
    private static final CoffeeType Latte = CoffeeType.Latte;

    public Latte(){
        super(CoffeeType.Latte);
    }
    protected String getCoffeeName(){
        return CoffeeType.Latte.toString();
    }
}
