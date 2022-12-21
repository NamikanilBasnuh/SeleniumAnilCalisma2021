package com.cybertek.tests.day8;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C_ReadExcelFile2 {

    public static void main(String[] args) throws IOException {

        String path = "vytrack_testusers.xlsx";

        File file = new File(path);
        System.out.println(file.exists()); //true
        Workbook workbook = WorkbookFactory.create(file);

        Sheet sheet = workbook.getSheet("QA2-short");
        System.out.println(sheet.getSheetName()); //QA2-short

        Row row1 = sheet.getRow(6);

        //I want to go to -> Turner
        Cell cell1 = row1.getCell(3);
        String value1 = cell1.getStringCellValue();
        System.out.println(value1);// Turner, I did.
        System.out.println("======================================================");
        //I want to go to Pierre
        Row row2 = sheet.getRow(12);
        Cell cell2 = row2.getCell(2);
        String value2 = cell2.getStringCellValue();
        System.out.println(value2);


        System.out.println("==================================================================================");
        //I want to go Sheet QA1-short -> and Row 12 cell value "Mante"

        //I Need to create another object to go to Another sheet! to change the sheets , I MUST CREATE A NEW SHEET OBJECT!
        Sheet sheet1 = workbook.getSheet("QA1-short");
        System.out.println(sheet1.getSheetName()); //I am checkcing and printing out my sheet name! //Bingo ->QA1-short<-

        Row row = sheet1.getRow(12); //row 13 -> index number is 12! it starts from 0! don't forget!
        Cell cell = row.getCell(3); // "Mante"'s cell number's index is 3

        String expectedReadValue = cell.getStringCellValue();

        System.out.println("expectedReadValue is = " + expectedReadValue); // Bingo-> Mante <-

        System.out.println("==================================================================================");
        //What if I want to read all Excel Sheet? ->QA1-short

        int totalRowNumberIndex = sheet1.getLastRowNum(); //Returns last index number of Row!
        int totalCellNumberIndex = row.getLastCellNum(); ///Returns last index number of Cell!
        System.out.println(row.getLastCellNum()); //5
        System.out.println(sheet1.getLastRowNum()); //15

        System.out.println("====================================================================================");
        // Because I have last index number of Row and cell. I create a simple logic below!
        //It goes to first row and reads all cells and then goes to next roll and read the next row's cell
        //until there is no row left to read!
        //i<=totalRowNumberIndex , j<=totalCellNumberIndex -No-> -1 -> Because It gives me the exact index number
        // Therefore, there is no need to do -1!!!
        for (int i = 0; i <= totalRowNumberIndex; i++) {
            row = sheet1.getRow(i);
            for (int j = 0; j <= totalCellNumberIndex; j++) {
                System.out.print((cell = row.getCell(j)) + " ");

            }
            System.out.println();
        }
        //BINGO -> You have read all excel sheet completely by using SIMPLE LOGIC!!!!! NO Iterator :)

        System.out.println("==================================================================================");

        //Now I collect All sheets data into an Array[]
        //I couldn't figure out 2 dimensional array. If I could , I could only separate them by Rows.
        // if i knew 2 dimensional array better, I could separete each cell with ","
        //And I could retrieve a single cell from my collected data.
        //STUDY 2 DIMENSIONAL ARRAYS !!!!!!!!

        int iterator = 0;
        String value = "";
        String[] arr=new String[totalRowNumberIndex];

        for (int i = 0; i <= totalRowNumberIndex; i++) {

            row = sheet1.getRow(i);
            for (int j = 0; j <= totalCellNumberIndex; j++) {
                if(j==totalCellNumberIndex){
                    value+=(cell = row.getCell(j))+";";
                }else {
                    value+=(cell = row.getCell(j))+" ";
                }

            }

        }
        arr=value.split(";");
        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length);
        System.out.println(arr[0]);//username password firstname lastname result null
        System.out.println(arr[1]);//user1 UserUser123 John Doe n/a null
        System.out.println(arr[2]);//user2 UserUser123 Kenneth Nicolas n/a null
        System.out.println(arr[3]);//user3 UserUser123 Yasmine McClure n/a null
        System.out.println(arr[4]);//user4 UserUser123 Aleen Williamson n/a null







    }


    }

