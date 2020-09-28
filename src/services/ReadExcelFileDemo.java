package services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.draw.geom.Formula;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFileDemo {
	public void display() throws IOException {
		int tabLength=getMinimumLength();
		try {
			File file=new File("C://Users//yashk//Downloads//stocksData.xlsx");
			FileInputStream fileInputStream=new FileInputStream(file);
			XSSFWorkbook xssfWorkbook=new XSSFWorkbook(fileInputStream);
			XSSFSheet hssfSheet=xssfWorkbook.getSheetAt(0);
			Iterator<Row> itr = hssfSheet.iterator();  
			while (itr.hasNext()){  
				Row row = itr.next();  
				Iterator<Cell> cellIterator = row.cellIterator();    
				while (cellIterator.hasNext()){  
					Cell cell = cellIterator.next();  
					switch (cell.getCellType())               
					{  
						case Cell.CELL_TYPE_STRING: 
							int length=cell.getStringCellValue().length();
							int a=tabLength-length;
							String str="";
							for(int i=0;i<a;i++) {
								str+=" ";
							}
							System.out.print(cell.getStringCellValue() + str+"\t\t\t");  
							break;  
						case Cell.CELL_TYPE_NUMERIC:      
							String str1=Double.toString(cell.getNumericCellValue());
							int b=str1.length()-tabLength;
							String str2="";
							for(int i=0;i<b;i++) {
								str2+=" ";
							}
					
							System.out.print(cell.getNumericCellValue() + str2 +"\t\t\t");  
							break;  
						default:  
					}  
				}  
				System.out.println("");  
			}  
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int getMinimumLength() {
		int maxlength=0;
		try {
			File file=new File("C://Users//yashk//Downloads//stocksData.xlsx");
			FileInputStream fileInputStream=new FileInputStream(file);
			XSSFWorkbook xssfWorkbook=new XSSFWorkbook(fileInputStream);
			XSSFSheet hssfSheet=xssfWorkbook.getSheetAt(0);
			Iterator<Row> itr = hssfSheet.iterator();
			while (itr.hasNext()){  
				Row row = itr.next();  
				Iterator<Cell> cellIterator = row.cellIterator();    
				while (cellIterator.hasNext()){  
					Cell cell = cellIterator.next();  
					switch (cell.getCellType())               
					{  
						case Cell.CELL_TYPE_STRING:      
						if(cell.getStringCellValue().length()>maxlength) {
							maxlength=cell.getStringCellValue().length();
						}
						break;  
						case Cell.CELL_TYPE_NUMERIC:      
						String a=Double.toString(cell.getNumericCellValue());
						int length=a.length();
						if(length>maxlength) {
							maxlength=length;
						}
						break;  
						default:  
					}  
				}  
				System.out.println("");  
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return maxlength;
	}
	
	public int  MaximumRows() {
		int max=0;
		try {
			File file=new File("C://Users//yashk//Downloads//stocksData.xlsx");
			FileInputStream fileInputStream=new FileInputStream(file);
			XSSFWorkbook xssfWorkbook=new XSSFWorkbook(fileInputStream);
			XSSFSheet hssfSheet=xssfWorkbook.getSheetAt(0);
			Iterator<Row> itr = hssfSheet.iterator();
			while(itr.hasNext()) {
				Row row=itr.next();
				max++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return max;
	}
	
	public void displayCharacterWise(char a) {
		try {
			File file=new File("C://Users//yashk//Downloads//stocksData.xlsx");
			FileInputStream fileInputStream=new FileInputStream(file);
			XSSFWorkbook xssfWorkbook=new XSSFWorkbook(fileInputStream);
			XSSFSheet hssfSheet=xssfWorkbook.getSheetAt(0);
			Iterator<Row> itr = hssfSheet.iterator();
			while (itr.hasNext()){  
				Row row =itr.next();  
				Iterator<Cell> cellIterator = row.cellIterator();    
				while (cellIterator.hasNext()){  
					Cell cell = cellIterator.next();  
					boolean checkValue=false;
					switch (cell.getCellType()) {  
						case Cell.CELL_TYPE_STRING:      
							if(cell.getStringCellValue().charAt(0)==a) {
								checkValue=true;
								System.out.print(cell.getStringCellValue()+"\t\t\t");
							}
						break;  
						case Cell.CELL_TYPE_NUMERIC:      
							if(checkValue==true) {
								System.out.print(cell.getNumericCellValue()+"\t\t\t");
							}
							break;    
					}  
				}  
				System.out.println("");  
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void displayHighestPrevValue() {
		try {
			File file=new File("C://Users//yashk//Downloads//stocksData.xlsx");
			FileInputStream fileInputStream=new FileInputStream(file);
			XSSFWorkbook xssfWorkbook=new XSSFWorkbook(fileInputStream);
			XSSFSheet hssfSheet=xssfWorkbook.getSheetAt(0);
			int max=MaximumRows();
			int colstyle=7;
			int rowstyle=0;
			double maxPrevValue=0;
			int rowi=0;
//			maxPrevValue=18805.1;
//			rowi=4;
			for(int i=1;i<max;i++) {
				Row row=hssfSheet.getRow(i);
				Cell cell=row.getCell(colstyle);
				if((double)cell.getNumericCellValue()>maxPrevValue) {
					maxPrevValue=(double)cell.getNumericCellValue();
					rowi=i;
				}
			}
			System.out.println("");  
			Row row=hssfSheet.getRow(rowi);
			Iterator<Cell> cellIterator = row.cellIterator();
			System.out.println("The Highest Prev Value is as Follows");
			System.out.println("Symbol\t\t\tSeries\t\t\tOpen\t\t\tHigh\t\t\tClose\t\t\tLast\t\t\tPrevClose\t\t\tTotalQty.\t\t\tTotalvolume\t\tTotalValue\t\t\tTimestamp\t\t\tTotalTrade\t\tISIN");
			while (cellIterator.hasNext()){  
				Cell cell = cellIterator.next();
				switch (cell.getCellType())               
				{  
					case Cell.CELL_TYPE_STRING: 
						System.out.print(cell.getStringCellValue() +"\t\t\t");  
						break;  
					case Cell.CELL_TYPE_NUMERIC:      
						System.out.print(cell.getNumericCellValue() +"\t\t\t");  
						break;  
					default:  
				}
//				System.out.println("");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void displayHighestQtyValue() {
		try {
			File file=new File("C://Users//yashk//Downloads//stocksData.xlsx");
			FileInputStream fileInputStream=new FileInputStream(file);
			XSSFWorkbook xssfWorkbook=new XSSFWorkbook(fileInputStream);
			XSSFSheet hssfSheet=xssfWorkbook.getSheetAt(0);
			int max=MaximumRows();
			int colstyle=8;
			int rowstyle=0;
			double maxQtyValue=0;
			int rowi=0;
			for(int i=1;i<max;i++) {
				Row row=hssfSheet.getRow(i);
				Cell cell=row.getCell(colstyle);
				if((double)cell.getNumericCellValue()>maxQtyValue) {
					maxQtyValue=(double)cell.getNumericCellValue();
					rowi=i;
				}
			}
			System.out.println("");  
			Row row=hssfSheet.getRow(rowi);
			Iterator<Cell> cellIterator = row.cellIterator();
			System.out.println("The Highest Qty Value is as Follows");
			System.out.println("Symbol\t\t\tSeries\t\t\tOpen\t\t\tHigh\t\t\tClose\t\t\tLast\t\t\tPrevClose\t\t\tTotalQty.\t\t\tTotalvolume\t\tTotalValue\t\t\tTimestamp\t\t\tTotalTrade\t\tISIN");
			while (cellIterator.hasNext()){  
				Cell cell = cellIterator.next();
				switch (cell.getCellType())               
				{  
					case Cell.CELL_TYPE_STRING: 
						System.out.print(cell.getStringCellValue() +"\t\t\t");  
						break;  
					case Cell.CELL_TYPE_NUMERIC:      
						System.out.print(cell.getNumericCellValue() +"\t\t\t");  
						break;  
					default:  
				}
//				System.out.println("");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
