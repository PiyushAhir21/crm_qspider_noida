package external_resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromProp {

	public static void main(String[] args) throws IOException {
//		step : 1 get the java representation object of the physical file
		FileInputStream fis = new FileInputStream("./src/main/resources/commonData.properties");

//		step 2 : by using load(), Load all the keys of properties file
		Properties pObj = new Properties();
		pObj.load(fis);

//		step 3 : by using getProperty(), fetch all the values
		String BROWSER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String UN = pObj.getProperty("un");
		String PWD = pObj.getProperty("pwd");

//		step 4 : by using setPropert(), write the data into properties file
		pObj.setProperty("firstName", "VijayKumar");

//		step 5 : By using store(), save the data
		FileOutputStream fos = new FileOutputStream("./src/main/resources/commonData.properties");
		pObj.store(fos, "Added First name in the commondata successfully!!!");
	}

}
