package external_resources;

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
//		step 1 : get the representation object of the physical file => excel file
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\testScriptData.xlsx");

//		step 2 : By using create() of WorkBookFactory, Open the workbook in read mode
		Workbook wb = WorkbookFactory.create(fis);

//		step 3 : By using getSheet(), Get control of sheet
		Sheet sh = wb.getSheet("org");

//		step 4 : By using getRow(), get control of row
		Row row = sh.getRow(1);

//		step 5 : By using getCell(), get control of cell
		Cell cell = row.getCell(0);

//		step 6 : By using getStringCellValue(), fetch the value
		String orgName = cell.getStringCellValue();
		System.out.println(orgName);
	}

}
