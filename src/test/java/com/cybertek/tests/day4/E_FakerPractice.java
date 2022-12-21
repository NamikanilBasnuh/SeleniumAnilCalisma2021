package com.cybertek.tests.day4;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class E_FakerPractice {


    @Test
    public void test() {
         //We use Faker github to do manipulation. It comes randomly whatever you choose!
        //We create an object first
        Faker faker = new Faker();
        String name=faker.name().fullName(); //returns String that's why you can equalize it to String
        System.out.println("name = " + name);

        String firstName = faker.name().firstName();
        System.out.println("firstName = " + firstName);

        String lastName = faker.name().lastName();
        System.out.println("lastName = " + lastName);

        String streetAddress = faker.address().streetAddress();
        System.out.println("streetAddress = " + streetAddress);

        String animal = faker.animal().name();
        System.out.println("animal = " + animal);


    }



}
