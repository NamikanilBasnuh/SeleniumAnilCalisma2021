package com.cybertek.tests.day8;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class D_Write_Into_ExcelFile {


    public static void main(String[] args) throws IOException {

        String path = "vytrack_testusers.xlsx";

        FileInputStream file = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(file);

        Sheet sheet = workbook.getSheet("QA1-short");
        Row row = sheet.getRow(1);
        Cell cell = row.getCell(4);
        String cellValue = cell.getStringCellValue();

         //Until here We read the cell.
         //new FileInputStream(path) ->WorkbookFactory.create(file) ->Sheet->Row->Cell-getStringCellValue
        System.out.println(cellValue); // -> it was -> n/a
        System.out.println("===================================");
        cell.setCellValue("learning"); // I changed it to "Learning". you will not see n/a anymore
                              // even it was printed before


        //It may seem like I changed it above BUT TO CHANGED THE VALUE I MUST USE THE BELOW LINE
        //OTHERWISE IT WILL NOT CHANGE!!!
        //it is like writing something but not saving in the page. if you don't save it, it will disappear
        //FileOutputStream USED TO WRITE THE DATA
         FileOutputStream fileOutputStream = new FileOutputStream(path);
         workbook.write(fileOutputStream);

         //Now it is change!!!
        //NOW IT IS TIME TO CLOSE EVERTHING! WE HAVE TO CLOSE

        System.out.println(cellValue); // it became learning
        file.close(); //comes from -> FileInputStream file = new FileInputStream(path);
        workbook.close(); //comes from ->Workbook workbook = WorkbookFactory.create(file);
        fileOutputStream.close(); //comes from ->FileOutputStream fileOutputStream = new FileOutputStream(path);



    }

}
