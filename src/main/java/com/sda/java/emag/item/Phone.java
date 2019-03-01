package com.sda.java.emag.item;


import java.util.Objects;

public class Phone extends Item{

    public static final Category CATEGORY = Category.ELECTRONICS;
    private final String brand;
    private final float display_size;
    private final String cpu;

    //facem constructorul:

    public Phone(String name, float price, String brand, float display_size, String cpu) {
        super(name, price, CATEGORY);
        this.brand = brand;
        this.display_size = display_size;
        this.cpu = cpu;
    }

    public String getBrand() {
        return brand;
    }

    public float getDisplay_size() {
        return display_size;
    }

    public String getCpu() {
        return cpu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Phone phone = (Phone) o;
        return Float.compare(phone.display_size, display_size) == 0 &&
                Objects.equals(brand, phone.brand) &&
                Objects.equals(cpu, phone.cpu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), brand, display_size, cpu);
    }

    public String showDetails(){
        final StringBuilder displayResult = new StringBuilder();

                displayResult.append(getItemDetails());   // append apartine de StringBuilder si adauga la Stringul de baza mai multe alte valori
                displayResult.append(SEPARATOR);
                displayResult.append(brand);
                displayResult.append(SEPARATOR);
                displayResult.append(cpu);
                displayResult.append(SEPARATOR);
                displayResult.append(display_size);
                displayResult.append("\n");

        System.out.println(displayResult);

        return displayResult.toString();


    }


}
