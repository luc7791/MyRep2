package com.sda.java.coffeemachine.menu;

import com.sda.java.coffeemachine.CoffeeType;

public class Expresso extends Coffee {

    private static final CoffeeType Expresso= CoffeeType.Expresso;
    public Expresso(){
        super(Expresso);
    }

    protected String getCoffeeName(){
        return Expresso.toString();
    }
}
