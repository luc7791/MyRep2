package com.sda.java.coffeemachine;

public class Stock {

    private int coffeeBeansStock;
    private int waterStock;
    private int sugarStock;
    private int milkStock;


    public int getCoffeeBeansStock() {
        return coffeeBeansStock;
    }
    public int removeCoffeeFromStock(int quantity){
        coffeeBeansStock -=quantity;
        return quantity;
    }

    public void addCoffeeBeansToStock(int quantity){
        coffeeBeansStock+=quantity;
    }

    public int getWaterStock() {
        return waterStock;
    }
    public int removeWaterFromStock(int quantity){
        waterStock -=quantity;
        return quantity;
    }
    public void addWatterToStock(int quantity){
        waterStock+=quantity;
    }

    public int getSugarStock() {
        return sugarStock;
    }
    public int removeSugarFromStock(int quantity){
        sugarStock -=quantity;
        return quantity;
    }

    public void addSugerToStock(int quantity){
        sugarStock+=quantity;
    }

    public int getMilkStock() {
        return milkStock;
    }
    public int removeMilkFromStock(int quantity){
        milkStock -=quantity;
        return quantity;
    }
    public void addMilkToStock(int quantity){
        milkStock+=quantity;
    }
}
