package Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Magento 
{
@Test(priority=1)
public void register() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("http://magento.com");
	driver.findElement(By.partialLinkText("Sign in")).click();
	driver.findElement(By.id("register")).click();
	driver.findElement(By.id("firstname")).sendKeys("shubha");
	driver.findElement(By.id("lastname")).sendKeys("rk");
	driver.findElement(By.id("email_address")).sendKeys("srk@gmail.com");////*[@id="form-validate"]/fieldset[1]/div[4]/label
driver.findElement(By.id("self_defined_company")).sendKeys("InfoInc");	
//Select ct=new Select(driver.findElement(By.id("company_type")));
Select cp = new Select(driver.findElement(By.id("company_type")));
//cp.selectByIndex(2);
cp.selectByValue("development");
//cp.selectByVisibleText("Develops Magento extensions");individual_role
Select cp1=new Select(driver.findElement(By.id("individual_role")));
//cp1.selectByIndex(2);
cp1.selectByValue("business/sales/marketing/merchandising");
Select cp2=new  Select(driver.findElement(By.id("country")));
//cp2.selectByIndex(1);
//cp2.selectByVisibleText("British Indian Ocean Territory");
cp2.selectByValue("IN");
driver.findElement(By.id("password")).sendKeys("welcome@1234");	
driver.findElement(By.id("password-confirmation")).sendKeys("welcome@1234");	

driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"recaptcha-f979c2ff515d921c34af9bd2aee8ef076b719d03\"]/div/div/iframe")));
driver.findElement(By.className("recaptcha-checkbox-border")).click();
driver.switchTo().defaultContent();
if(!driver.findElement(By.id("agree_terms")).isSelected())
{
driver.findElement(By.id("agree_terms")).click();
}
driver.quit();
}
	@Test(priority=2,enabled=false) 
	public void login() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://magento.com");
		driver.findElement(By.partialLinkText("Sign in")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("srk@gmail.com");
		
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys("welcome");
		driver.findElement(By.id("send2")).click();
		Thread.sleep(5000);
		String error =driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div")).getText();
	System.out.println(error);
	
	driver.quit();
		
	}
	
	
}
