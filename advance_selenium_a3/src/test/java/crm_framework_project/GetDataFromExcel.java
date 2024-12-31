package crm_framework_project;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\testScriptData.xlsx");

		Workbook wb = WorkbookFactory.create(fis);

//		String orgName = wb.getSheet("org").getRow(1).getCell(0).getStringCellValue();
		
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(1);
		Cell cell = row.getCell(0);
		String orgName = cell.getStringCellValue();

		System.out.println(orgName);
		
		wb.close();
	}

}
