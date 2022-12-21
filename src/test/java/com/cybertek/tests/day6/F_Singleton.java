package com.cybertek.tests.day6;

public class F_Singleton {


    //Making the constructor private, so we limit creating objects from this class
    private F_Singleton(){}

    //Making the String private so that we can only reach this using getter method
    private static String word;

    //Creating a 'getter' method to allow users to reach private String above
    public static String getWord(){

        if (word == null){

            System.out.println("First time call. Word Object is null. " +
                    "Assigning value to it now!");
            word = "Apple";

        }else{
            System.out.println("Word already has value");
        }

        return word;

    }

}
