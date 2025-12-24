package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;

public class ExcelUtility {
	
	static FileInputStream f;  //to read details from file
	static XSSFWorkbook wb;    //apache class to read details from the workbook
	static XSSFSheet sh;       //apache inbuilt class to read details from sheet
	
	public static String getStringData(int a,int b, String sheet) throws IOException
	{
		f=new FileInputStream(Constant.TESTDATA);
		wb= new XSSFWorkbook(f);
		sh=wb.getSheet(sheet);  //getSheet is a method used to get details from sheet
		XSSFRow r =sh.getRow(a);   //XSSFRow is a class to get details from row
		XSSFCell c = r.getCell(b); //XSSFCell is a class to get details from column
		return c.getStringCellValue(); // to get details from string in the cell
	}
	
	public static String getIntegerData(int a,int b, String sheet) throws IOException 
	{
		f=new FileInputStream(Constant.TESTDATA);
		wb= new XSSFWorkbook(f);
		sh=wb.getSheet(sheet);  
		XSSFRow r =sh.getRow(a);   
		XSSFCell c = r.getCell(b); 
		int j=(int)c.getNumericCellValue();  //type casting
		return String.valueOf(j);  //valueOf() -> used to convert any(int) value to string
	}

}
