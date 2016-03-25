import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class VerifyRanorexApp {
	
	static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception {
		if (driver == null){
			driver=new FirefoxDriver();
			driver.get("http://www.ranorex.com/web-testing-examples/vip/");	   
			Thread.sleep(2000);		
		    driver.manage().window().maximize()
		}
	}

	@Test
	public void verifyAddRanorexUser() throws InterruptedException {
		String firstName="Tripti";
		String lastName = "Mittal";
				
		driver.findElement(By.id("FirstName")).sendKeys(firstName);
		driver.findElement(By.id("LastName")).sendKeys(lastName);
		driver.findElement(By.cssSelector("input[id='Gender'][value='female']")).click();
		driver.findElement(By.id("Add")).click();
		Thread.sleep(2000);
		
		String firstNameText= driver.findElement(By.xpath("//table[@id='VIPs']/tbody/tr[2]/td[2]")).getText();
	    String lastNameText= driver.findElement(By.xpath("//table[@id='VIPs']/tbody/tr[2]/td[3]")).getText();
	    driver.findElement(By.id("Clear")).click();
	   	    
	    Assert.assertEquals("First Name Mismatched", firstNameText, firstName);
	    Assert.assertEquals("Last Name Mismatched",lastNameText , lastName);
	
	}
	
	@Test
	public void verifyAddRanorexUserNegative() throws InterruptedException {
		String firstName="Deepak";
		String lastName = "Rupani";
				
		driver.findElement(By.id("FirstName")).sendKeys(firstName);
		driver.findElement(By.id("LastName")).sendKeys(lastName);
		driver.findElement(By.cssSelector("input[id='Gender'][value='male']")).click();
		driver.findElement(By.id("Add")).click();
		Thread.sleep(2000);
		
		String firstNameText= driver.findElement(By.xpath("//table[@id='VIPs']/tbody/tr[2]/td[2]")).getText();
	    String lastNameText= driver.findElement(By.xpath("//table[@id='VIPs']/tbody/tr[2]/td[3]")).getText();
	    driver.findElement(By.id("Clear")).click();
	    
	    //firstName="Sachin";
	   	    
	    Assert.assertEquals("First Name Mismatched", firstNameText, firstName);
	    Assert.assertEquals("Last Name Mismatched",lastNameText , lastName);
	
	}
	
	@AfterClass
	public static void afterClass(){
		//close the driver
		driver.quit();
	}

}
