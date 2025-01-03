package generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	public String getDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src\\main\\resources\\commonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);

		return pObj.getProperty(key);
	}

	public String getDataFromExcelFile(String sheet, int rowNum, int cellNum) throws IOException {
		FileInputStream fis1 = new FileInputStream("C:\\Users\\User\\Desktop\\testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet(sheet);
		Row row = sh.getRow(rowNum);
		int random = JavaUtility.generateRandomNumer();
		String data = row.getCell(cellNum).getStringCellValue() + random;
		return data;
	}
}
