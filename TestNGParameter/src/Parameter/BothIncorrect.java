package Parameter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BothIncorrect {
	@Test
	@Parameters({"NAme","Pass"})
	public void bothINcorrect(String uname,String password)
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
