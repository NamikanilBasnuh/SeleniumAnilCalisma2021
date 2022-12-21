package com.cybertek.tests.day8;

import com.cybertek.Utility.ExcelUtil;

import java.util.Arrays;

public class E_Using_ExcelUtilClass {

    public static void main(String[] args) {

        //ExcelUtil obj2 = new ExcelUtil("QA1-short");
        //or
        ExcelUtil obj = new ExcelUtil("vytrack_testusers.xlsx","QA1-short");


        System.out.println(obj.columnCount());
        System.out.println("==================================================================");
        System.out.println(obj.getCellData(1, 3));
        System.out.println("==================================================================");
        System.out.println(Arrays.deepToString(obj.getDataArray()));
        System.out.println("==================================================================");
        System.out.println(obj.getDataList());
        //ustekini bul iyice anla. aynisini yazabiliyor ol!
    }
}
