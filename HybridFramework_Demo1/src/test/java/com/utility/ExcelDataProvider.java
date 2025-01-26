package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
    XSSFWorkbook workb;

    // Method to initialize the workbook
    public void getData() throws IOException {
        String excelPath = "C:/Users/sandi/eclipse-workspace/QDTAS/HybridFramework_Demo1/TestData/pqr.xlsx";
        //C:/Users/sandi/eclipse-workspace/QDTAS/BDD_Cucumber_Demo_Project2/TestData/abcd.xlsx
        File src = new File(excelPath);
        FileInputStream excel = new FileInputStream(src);
        workb = new XSSFWorkbook(excel);
    }

    // Method to fetch string data from a specific cell
    public String getStringData(String sheetName, int row, int column) {
        if (workb == null) {
            throw new IllegalStateException("Workbook is not initialized. Call getData() first.");
        }
        return workb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }
    public double getNumericData(String sheetname, int row,int column) {
		
    	return workb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
    	}

  
   }

