import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Login {
	
	//String[][] data;
	
	@DataProvider
	public String[][] LoginDataProvider() throws BiffException, IOException {
		
		FileInputStream excel=new FileInputStream("C:\\Users\\Boopathi\\Documents\\Inputcredentioals.xls");
		Workbook workbk=Workbook.getWorkbook(excel);
		Sheet sht=workbk.getSheet(0);
		
		int rowcount=sht.getRows();
		int columncount=sht.getColumns();
		
		String data[][]=new String[rowcount-1][columncount];
		for(int i=1;i<rowcount;i++)
		{
			for(int j=0;j<columncount;j++)
			{
				data[i-1][j]=sht.getCell(j, i).getContents();
			}
		}
		
		
		return data;
		
		
	}
	
	
	@Test(dataProvider = "LoginDataProvider")
	public void LoginPage(String uname,String password)
	{

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Boopathi\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.id("txtUsername")).sendKeys(uname);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.name("Submit")).click();
		driver.close();
	}

}
