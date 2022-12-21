package com.cybertek.tests.day6;

import org.testng.annotations.Test;

public class G_SingletonPractice {



    @Test
    public void singleton_test1(){

        String str1=F_Singleton.getWord();
        System.out.println("str1 = "+str1);

        String str2=F_Singleton.getWord();
        System.out.println("str2 = "+str2);

        String str3=F_Singleton.getWord();
        System.out.println("str3 = "+str3);

        System.out.println("=======================");
        System.out.println("Driver is still not null. it has already set!!!");
    }


    @Test
    public void singleton_test2(){

        String str4=F_Singleton.getWord();
        System.out.println("str1 = "+str4);


    }
}
