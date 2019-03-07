package com.sda.java.coffeemachine;

public class Ex {

        int centuryFromYear(int year) {

            int centuryFromYear;
            int rest= year%100;
            if(rest==0){
                centuryFromYear=year/100;
                return centuryFromYear;
            }else{
               centuryFromYear=year/100+1;
                return centuryFromYear;
            }

        }

}
