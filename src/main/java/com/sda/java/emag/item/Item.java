package com.sda.java.emag.item;
import com.sda.java.emag.businessLogic.Displayable;

import java.io.Serializable;
import java.util.Objects;

public abstract class Item implements Displayable, Serializable {                  //clasele abstracte permit sa apelam metodele din copii
    public Item(String name, float price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    private final String name;
    private float price;
   private final Category category;
    static final String SEPARATOR= " ";


    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Float.compare(item.price, price) == 0 &&
                Objects.equals(name, item.name) &&
                category == item.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, category);
    }

    public String getItemDetails() {
        final StringBuilder displayResults=new StringBuilder();
        displayResults.append(name);   // append apartine de StringBuilder si adauga la Stringul de baza mai multe alte valori
        displayResults.append(SEPARATOR);
        displayResults.append(price);
        displayResults.append(SEPARATOR);
        displayResults.append(category);
        displayResults.append(System.lineSeparator());
//        displayResults.append("\n");
        return displayResults.toString();
    }



}

