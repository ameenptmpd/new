package SeleniumProject.SeleniumProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;  
import org.testng.annotations.BeforeTest;  
import org.testng.annotations.Test;
import org.testng.Assert;

import junit.framework.TestCase;  

public class BankingAppTest extends TestCase{
	
	//download chrom driver from https://googlechromelabs.github.io/chrome-for-testing/
	public String baseUrl = "http://3.144.5.42:8089/seeddata";  
	String driverPath = "D:\\chromedriver-win64\\chromedriver.exe";  
	
	public WebDriver driver;
	
	@Test             
	public void testWeb() {      
		// set the system property for Chrome driver      
		System.out.println("inside testGoogle");
		System.setProperty("webdriver.chrome.driver", driverPath);  
		System.out.println("inside testGoogle "+driverPath);
		// Create driver object for CHROME browser  
		driver = new ChromeDriver();  
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  
		driver.manage().window().maximize();  
		driver.get(baseUrl);  
		
		// get the current URL of the page  
		String URL= driver.getCurrentUrl();  
		System.out.print(URL);  
		
		//get the title of the page  
		String title = driver.getTitle();                  
		System.out.println(title);
		

        waitForMe(2000);
		// Find the search input element
		WebElement e = driver.findElement(By.xpath("//*[text()='Data seeded successfully!!!']"));
		System.out.println("Element with text(): [" + e.getText() +"]");
		Assert.assertEquals("Data seeded successfully!!!", e.getText());
		
		//driver.quit();
        
		waitForMe(1000);
        
	}   
	
	public void waitForMe(int time) {
		// Wait for a few seconds to see the results
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	@BeforeTest  
	public void beforeTest() {    
		System.out.println("before test");  
	}     
	@AfterTest  
	public void afterTest() {  
		//driver.quit();  
		System.out.println("after test");  
	}         	

}
