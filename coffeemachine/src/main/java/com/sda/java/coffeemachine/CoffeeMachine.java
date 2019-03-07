package com.sda.java.coffeemachine;
import com.sda.java.coffeemachine.menu.Coffee;
import com.sda.java.coffeemachine.menu.Expresso;
import com.sda.java.coffeemachine.menu.FilterCoffee;
import com.sda.java.coffeemachine.menu.Latte;

public class CoffeeMachine {

    private Stock stock=new Stock();
    public Stock getStock() {
        return stock;
    }

    public static void main(String[] args) throws Exception {
        final CoffeeMachine coffeeMachine = new CoffeeMachine();
        Stock stock =coffeeMachine.getStock();
        stock.removeCoffeeFromStock(100);                   //100 este exemplu

        //user selects coffee type
        coffeeMachine.selectCoffeeType(CoffeeType.Expresso);           // exemplu de selectie

        //user pressStart
        final Coffee coffee=coffeeMachine.prepareCoffee();
        System.out.println("Consuming the coffe: " + coffee);
    }

    private  CoffeeType coffeeType=CoffeeType.FilterCoffee;   // o varianta default
    public void selectCoffeeType(CoffeeType coffeeType) {
        // to do: add check if credit is sufficient
        this.coffeeType = coffeeType;
    }

    public Coffee prepareCoffee() throws Exception {
        if(stock.getCoffeeBeansStock()>coffeeType.getCoffeeBeansRequired()) {
            stock.removeCoffeeFromStock(coffeeType.getCoffeeBeansRequired());
            return  createCoffee();
        }
            throw new Exception("Cannot create Coffee");
    }

    public Coffee createCoffee() {
        switch (coffeeType){
            case Latte: return new Latte();
            case Expresso: return new Expresso();
            case FilterCoffee:return new FilterCoffee();
            default:return new FilterCoffee();
        }
    }


    public int addCredit(){

    return 0;
    }
    public int returnCredit(){

        return 0;
    }


}
