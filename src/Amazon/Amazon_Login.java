package Amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Amazon_Login {
	
	@Test(dataProvider = "login_amazon")
	
	public void login_amazon(String number, String password) {
		
		Config_Reader cr = new Config_Reader();
		
		System.setProperty("webdriver.gecko.driver", cr.getgeckopath());
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(cr.geturl());
		driver.findElement(By.xpath("//*[@id=\"nav-link-yourAccount\"]/span[1]")).click();
		driver.findElement(By.id("ap_email")).sendKeys(number);
		//driver.findElement(By.linkText("Continue")).click();
		driver.findElement(By.linkText("Need help?")).click();
		driver.findElement(By.linkText("Forgot Password")).click();
		driver.findElement(By.id("ap_email")).sendKeys(number);
		
		//driver.findElement(By.id("ap_password")).sendKeys(password);
		//driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		
	}
	
	@DataProvider(name = "login_amazon")
	
	public Object[][] passData(){

		Config_Reader cr = new Config_Reader();

		Amazon_ex ae = new Amazon_ex(cr.getepath());

		
		int row = ae.getrowCount();
		Object[][] arr = new Object[row][2];


		
		for(int i=0;i<row;i++) {
			
			arr[i][0] = ae.getData(0,i,0);
			arr[i][1] = ae.getData(0,i,1);

			
			
		}
		
		return arr;
		
		
	}

}
