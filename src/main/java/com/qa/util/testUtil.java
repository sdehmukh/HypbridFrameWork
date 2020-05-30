package com.qa.util;

import com.qa.base.testBase;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class testUtil extends testBase {
    public static long PAGE_LOAD_TIMEOUT =60;
    public static  long IMPLICIT_WAIT=60;
    public static  String sheetPath="D:\\HypbridFrameWork\\src\\test\\data\\Book1.xlsx";
    static Workbook book;
    static Sheet sheet;
    public void switchToFrame(){
        //driver.switchTo().frame();
    }

    @DataProvider
    public static Object[][] getSheetData(String sheetName)
    {
        FileInputStream fp=null;
        try{
            fp=new FileInputStream(sheetPath);
        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        try
        {
            book=WorkbookFactory.create(fp);
        }catch (InvalidFormatException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        sheet=book.getSheet(sheetName);
        Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for(int i=0;i<sheet.getLastRowNum();i++)
        {
            for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
            {
                System.out.println();
                data[i][k]=sheet.getRow(i+1).getCell(k).toString();
                System.out.println(data[i][k]);
            }
        }
  return data;
    }

}
