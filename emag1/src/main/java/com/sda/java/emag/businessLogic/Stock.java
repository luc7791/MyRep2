package com.sda.java.emag.businessLogic;
import com.sda.java.emag.item.Item;

import java.io.*;
import java.util.Map;

public class Stock implements Serializable {
    static final String SEPARATOR= " ";
    //facem doua metode add+retrieve (eliminate)  items. Verificam intai daca exista itemul in map
       private final Map<Item,Integer> items;

       private Object mutex;            // declaram un nou obiect;
        public Stock(Map<Item,Integer> items,Object mutex) {                // in afara obiectului normal Stock, am adaugat inca unul "mutex"
        this.items = items;
        this.mutex=mutex;
    }


        public int addItem(Item article,int supplyQuantity) {
            final Integer previousValue = items.putIfAbsent(article, supplyQuantity);
            if (previousValue == null) {
                return supplyQuantity;
            }
            synchronized (this) {                   // sincronizare - adica obliga sa se ruleze pe rand metoda daca e apelata de mai multi. Se poate inlocui cu alt obiect (mutex) nu doar cel curent (this)
                final int supply;

                if (items.containsKey(article)) {
                    supply = items.get(article) + supplyQuantity;    // get(article) - returneaza Integer din Map (cantitatea curenta)
                    items.put(article, supply);                         // actualizeaza colectia (pune in items cantitatea respectiva)
                    return supply;
                }
                items.put(article, supplyQuantity);
                return supplyQuantity;
            }
        }


           public synchronized int retrieveItem(Item article,int consumeQuantity){

            final int updatedQuantity;
            if (items.get(article)>consumeQuantity ){
                   updatedQuantity = items.get(article) - consumeQuantity;
                   items.put(article,updatedQuantity);
                   return consumeQuantity;
               } else {
                Integer integer = items.get(article);
                items.put(article,0);

                return integer;

            }
           }

           public String showItems (){
            final StringBuilder displayResults=new StringBuilder();
//            final String displayResults="";
            for (Map.Entry<Item,Integer> itemEntry : items.entrySet()){     // pt fiecare entry de item
//                displayItems=displayItems+item.getKey().getName()+"\n";
                final Item item = itemEntry.getKey();
                displayResults.append(item.showDetails());   // append apartine de StringBuilder si adauga la Stringul de baza mai multe alte valori
                displayResults.append(SEPARATOR);
                displayResults.append(itemEntry.getValue());
                displayResults.append(System.lineSeparator());

            }
               System.out.println(displayResults);

            return displayResults.toString();
           }

           public void saveState() throws IOException {             //serializeaza obiectul din clasa AppliationEmag in fisierul de mai jos
               final FileOutputStream fileStream = new FileOutputStream("C:\\Users\\Lucian M\\Desktop\\MyFirstJavaFolder\\myFirstJavaFile.txt");
               final BufferedOutputStream bufferedStream= new BufferedOutputStream(fileStream);
               final ObjectOutputStream outObject = new ObjectOutputStream (bufferedStream);
               outObject.writeObject(this);         // this este obiectul curent
               outObject.close();
               fileStream.close();

           }

           public void loadState() throws IOException, ClassNotFoundException {   //deserializeaza

               final FileInputStream fileStream = new FileInputStream("C:\\Users\\Lucian M\\Desktop\\MyFirstJavaFolder\\myFirstJavaFile.txt");
               final BufferedInputStream bufferedStream= new BufferedInputStream(fileStream);
               final ObjectInputStream inObject = new ObjectInputStream (fileStream);
                final Stock readObject=(Stock)inObject.readObject();
               inObject.close();
               fileStream.close();

             }
}

