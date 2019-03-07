package com.sda.java.emag.item;

import java.util.Objects;

public class Shoes extends Item{

    private final String brand;
    private final Integer size;
    private final String color;

    public Shoes(String name, float price, String brand, Integer size, String color) {
        super(name, price, Category.FASHION);
        this.brand = brand;
        this.size = size;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Shoes shoes = (Shoes) o;
        return Objects.equals(brand, shoes.brand) &&
                Objects.equals(size, shoes.size) &&
                Objects.equals(color, shoes.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), brand, size, color);
    }

    public String showDetails() {
        final StringBuilder displayResult = new StringBuilder();

        displayResult.append(getItemDetails());   // append apartine de StringBuilder si adauga la Stringul de baza mai multe alte valori
        displayResult.append(SEPARATOR);
        displayResult.append(brand);
        displayResult.append(SEPARATOR);
        displayResult.append(size);
        displayResult.append(SEPARATOR);
        displayResult.append(color);
        displayResult.append("\n");

        System.out.println(displayResult);

        return displayResult.toString();
    }

}
