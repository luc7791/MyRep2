package com.sda.java.coffeemachine;

public enum CoffeeType  {

    Expresso(5,50,0,0),
    Latte (2,100,5,100),
    FilterCoffee(10,150,2,10);

    private final int coffeeBeansRequired;
    private final int waterRequired;
    private final  int sugarRequired;
    private final int milkRequired;

   CoffeeType(int coffee, int waterRequired, int sugarRequired, int milk) {
        this.coffeeBeansRequired = coffee;
        this.waterRequired = waterRequired;
        this.sugarRequired = sugarRequired;
        this.milkRequired = milk;
    }

    public int getCoffeeBeansRequired() {
        return coffeeBeansRequired;
    }

    public int getWaterRequired() {
        return waterRequired;
    }

    public int getSugarRequired() {
        return sugarRequired;
    }

    public int getMilkRequired() {
        return milkRequired;
    }

}
