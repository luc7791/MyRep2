package com.sda.java.coffeemachine.menu;

import com.sda.java.coffeemachine.CoffeeType;

public abstract class Coffee {   // abstract permite apelarea metodelor din copii
    private final int coffee;
    private final int water;
    private final  int sugar;
    private final int milk;


    public Coffee (CoffeeType coffeeType){
        this.coffee=coffeeType.getCoffeeBeansRequired();
        this.water=coffeeType.getWaterRequired();
        this.sugar=coffeeType.getSugarRequired();
        this.milk=coffeeType.getMilkRequired();


    }
    protected abstract String getCoffeeName();

    @Override                           // a aparut prin generare toString
    public String toString() {
        return getCoffeeName()+"{" +
                "coffee=" + coffee +
                ", water=" + water +
                ", sugar=" + sugar +
                ", milk=" + milk +
                '}';
    }
}


