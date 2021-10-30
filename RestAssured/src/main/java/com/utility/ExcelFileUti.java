package com.utility;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelFileUti {
	public String getDataFromExcel(String sheet,int row,int cell) throws Throwable, Throwable {
		FileInputStream fis=new FileInputStream(IpathConstant.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		 Row rw = sh.getRow(row);
		 Cell cl = rw.getCell(cell);
				 String data=cl.getStringCellValue();
		 return data;
	}

}
