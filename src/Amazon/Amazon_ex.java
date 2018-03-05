package Amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Amazon_ex {
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	public Amazon_ex(String epath) {
		
		File src = new File(epath);
		try{
			FileInputStream fis = new FileInputStream(src);
		
			wb = new XSSFWorkbook(fis);
		} 
		
		catch (Exception e) {
        System.out.println(e.getMessage());		
        
		}
		
	}
	

	
	public String getData(int sheetnumber, int row, int column) {
		
		sheet1 = wb.getSheetAt(sheetnumber);
		DataFormatter df = new DataFormatter();
		String data = df.formatCellValue(sheet1.getRow(row).getCell(column));
		return data;
		
	
}
	
	
	public int getrowCount() {
		int row = wb.getSheetAt(0).getLastRowNum();
		row = row+1;
		return row;
	}
}
