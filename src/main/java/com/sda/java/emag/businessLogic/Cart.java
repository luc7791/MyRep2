package com.sda.java.emag.businessLogic;
import com.sda.java.emag.item.Item;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Cart {

    static final String SEPARATOR = " ";
    //facem doua metode add+remove  items Actualizam si un total. Verificam intai daca exista itemul in map
    private Map<Item, Integer> cartItems;

    private float total;

    public Cart(Map<Item, Integer> cartItems) {
        this.cartItems = cartItems;
    }

    public int addCartItem(Item article, int addQuantity) {
        total += addQuantity + article.getPrice();
        if (cartItems.containsKey(article)) {
            final int updatedQuantity = cartItems.get(article) + addQuantity;
            cartItems.put(article, updatedQuantity);                         // actualizeaza colectia (pune in items cantitatea respectiva
            return updatedQuantity;
        }
        cartItems.put(article, addQuantity);
        return addQuantity;
    }

    public int removeItem(Item item, int removeQuantity) {

        if (!cartItems.containsKey(item)) {
            return 0;
        }
        int currentQuantity = cartItems.get(item);
        if (currentQuantity < removeQuantity) {
            cartItems.put(item, 0);
            total -= currentQuantity * item.getPrice();
            return currentQuantity;
        }
        int updatedQuantity = currentQuantity - removeQuantity;
        cartItems.put(item, updatedQuantity);
        total -= removeQuantity * item.getPrice();
        return removeQuantity;

    }

    public Map<Item, Integer> removeAll() {
        final Map<Item, Integer> previousState = cartItems;
        cartItems = new HashMap<>();
        total = 0;
        return previousState;
    }

    public String checkout() {

        final String processedItems = getCurrentItems();

        removeAll();
       return processedItems;


//        final StringBuilder displayResults = new StringBuilder();
//        for (Map.Entry<Item, Integer> itemEntry : cartItems.entrySet()) {     // pt fiecare entry de item din setul de itemi
//
//            final Item item = itemEntry.getKey();
//            displayResults.append(item.showDetails());   // append apartine de StringBuilder si adauga la Stringul de baza mai multe alte valori
//            displayResults.append(SEPARATOR);
//            displayResults.append(itemEntry.getValue());
//            displayResults.append(System.lineSeparator());
//        }
//        System.out.println(displayResults);
//
//        return displayResults.toString();
    }

    public String getCurrentItems() {
        return cartItems.entrySet().stream().map(itemEntry ->  // din lista: preia setul de itemi (previousState) apoi se duce pe fiecare si-l transforma in String
                    {
                        final StringBuilder displayResults = new StringBuilder();         // construim o lista de stringuri intr-unul mai mare
                        final Item item = itemEntry.getKey();
                        displayResults.append(item.showDetails());   // append apartine de StringBuilder si adauga la Stringul de baza mai multe alte valori
                        displayResults.append(SEPARATOR);
                        displayResults.append(itemEntry.getValue());
                        displayResults.append(System.lineSeparator());
//                        return item.toString();       // returneaza adresa din memorie, nu valorile
                        return displayResults.toString();

                    }
            )
                    .collect(Collectors.joining(System.lineSeparator()));
    }



    public void print() throws IOException {
        final FileWriter fileWriter = new FileWriter("C:\\Users\\Lucian M\\Desktop\\MyFirstJavaFolder\\myFirstJavaFile.txt",true);  // daca am true - va adauga ceva nou
        final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        final String processedItems = getCurrentItems();
        bufferedWriter.write(processedItems);
        bufferedWriter.append(' ');
        bufferedWriter.append("adaug un text patru");
        bufferedWriter.flush();   // forces write on disk
        bufferedWriter.close();
    }


}