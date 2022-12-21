package com.cybertek.tests.day8;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class A_ReadTextFile_CsvFile {

    //"ShoppingList.txt"; -> File dragged and dropped into the project! right into the project name

    public static void main(String[] args) throws FileNotFoundException  {
        //Go find the .text and copy to Content Root!
        //content root copied and pasted into a String path = ShoppingList.txt
        String path = "ShoppingList.txt";

        //File class is being used like we use FileInputStream for properties .
        //path pasted into the File constructor;
        //"ShoppingList.txt" is loaded into File
        File file1 =new File(path);


        //file.exists() to check file is exist or not -> boolean expression
        System.out.println(file1.exists()); //true

        //to read the file we use Scanner class!!!
        //file is loaded into Scanner Constructor!
        //It throws and exception! Handle the exception!
        // throw FileNotFoundException next to static level (psvm)
        //or try/cath but you have to create a logic

        //scanner.nextLine() or next() reads the file but only 1 line not full of it!

            Scanner scanner = new Scanner(file1);
            System.out.println(scanner.nextLine()); //1- Water

        //scanner.hasNext() -> means if there is line left to read! ->returns boolean expression!

       //Create a while loop


        while (scanner.hasNext()){  //This loop means that if there is a line to read, read it and print!
                                   //It prints out all text(file)
            System.out.println(scanner.nextLine());
        }
        //AFTER YOU READ EVERYTHING BY LOOP YOU MUST CREATE A NEW OBJECT. OTHERWISE NOTHING TO READ LEFT!
        //IT WILL NOT READ ANYMORE AND IT WILL THROW A NoSuchElementException

        System.out.println("=================================================");

        //Conclusion, it goes one by one. There is no way to go to 3rd index directly
        //Therefore, I collected them into a list so, I can reuse them if I need to!
        // I am a genius! :)

        Scanner scanner1 = new Scanner(file1);

        List<String > allTextListToReuse = new ArrayList<>();

        while (scanner1.hasNext()){
            allTextListToReuse.add(scanner1.nextLine());
        }
        System.out.println(allTextListToReuse);
        //[1- Water, 2- Bread, 3- Tomatoes, 4- Meat, 5- Cheese, 6- Face Masks]

        System.out.println(allTextListToReuse.get(3)); //4- Meat ->index 3 is Meat!

        System.out.println("=============================================================================");
        System.out.println("New READING-> csv file=======================================================");

        //cvs file reading -> grades.csv

        String grades_csvPath = "grades.csv";
        File file2 = new File(grades_csvPath);

        Scanner scanner2 = new Scanner(file2);

        List<String> listOfGrades_csv = new ArrayList<>();

        while (scanner2.hasNext()){

            listOfGrades_csv.add(scanner2.nextLine());

        }
        System.out.println(listOfGrades_csv);
        //[#Name,  Grade, 1,Martin,98, 2,Monika,95, 3,Rajesh,100]

        System.out.println("===================================================");

        for (int i=0; i<=listOfGrades_csv.size()-1;i++){
            System.out.println(listOfGrades_csv.get(i));
        }

        System.out.println("======================================================================");

        //2nd way full csv as string
        Scanner scanner3 = new Scanner(file2);

        while (scanner3.hasNext()){
            System.out.println(scanner3.nextLine());
        }

    }





}
