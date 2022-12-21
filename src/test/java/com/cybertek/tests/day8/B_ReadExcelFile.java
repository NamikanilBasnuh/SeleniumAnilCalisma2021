package com.cybertek.tests.day8;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class B_ReadExcelFile {

    public static void main(String[] args) throws IOException {

        String path = "vytrack_testusers.xlsx";
        File file =new File(path);
        System.out.println(file.exists()); //it is exist! Checked!

        //Step 1. Create excel file object
        //workbook object represents excel file
        //it has spreadsheets that we gonna read as well
        //Workbook comes from apache-poi
        //it will throw an IOException

        Workbook workbook = WorkbookFactory.create(file);
        //NOW WE ARE IN THE EXCEL FILE! BUT WE HAVE TO GO IN TO MORE!
        //workbook.getNumberOfSheets() ->gets how many sheets you have in your Excell file->returns number!
        int numberOfSheets = workbook.getNumberOfSheets();
        System.out.println(numberOfSheets);//6 sheets you have!(look on the bottom...QA1-All..)

        //NOW WE HAVE TO CHOOSE ONE SHEET TO GO INTO
        //Sheet class comes from Apache-poi.
        Sheet sheet = workbook.getSheet("QA3-short"); //->takes String Argument //It is getting into the sheet!

        //Now We are in the Sheet! We will choose a Row to go in!!!
        Row row1 =sheet.getRow(0); //we are into first row and index is 0 ->gets number(int) argument in it!

        //Now We are in the first Row of the QA3-short sheet
        //We will go in to the first cell, index number 0
        Cell cell1 = row1.getCell(0);//get int in it.

        //Now in  QA3-short sheet,first Row and first cell!
        //We can print it out by using getStringCellValue(); -> Returns String!
        String value1 = cell1.getStringCellValue();
        System.out.println("Value of  QA3-short sheet, 1.row and 1.cell is: " + value1); //execute
        System.out.println("\n===========================================================================");

        //get all spreadsheet names
        //Below method gives all Sheet names into Excel File!
        workbook.forEach(sheetName-> System.out.println(sheetName.getSheetName()));
        System.out.println("==========================================");

      /*  for (Sheet item:workbook) {
            System.out.println(item.getSheetName());
        }
                  */
        //Above loop is same thing with -> workbook.forEach(sheetName-> System.out.println(sheetName.getSheetName()));


        //What if we want to print out all list?
        //Below, We did! It is hard to understand but we did! :)

        //We are already in QA3-short sheet
        //Row should be iterated , as long as it is iterated
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()){
            Iterator<Cell> tempCellIterator = rowIterator.next().cellIterator();
            while (tempCellIterator.hasNext()){
                String value = tempCellIterator.next().getStringCellValue();
                System.out.print(value+" ");
            }
            System.out.println();
        }
        //Yukarida anladigim su: Zaten Sheet in icindeyiz! iterator ilk row a giriyor. Ilk rowun icindeki ilk cell e giriyor.
        //ilk cell den son cell e kadar o row un icindeki butun celleri yazdiriyor. Sonra 2. row a geciyor
        // Bu ta ki son row a kadar devam ediyor! while(icinde olan sey row un ve cellin bitmesini isaret ediyor)
        //Row bittigi anda cikiyor tamamen looptan!






    }


}
