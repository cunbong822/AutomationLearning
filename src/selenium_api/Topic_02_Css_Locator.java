package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_02_Css_Locator {
	WebDriver driver;
  @Test
  public void  TC_01_LoginWithUserPassEmpty() {
	  driver.get("http://live.guru99.com/index.php");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//span[@class='label' and text()='Account']")).click();
	  driver.findElement(By.xpath("//div[@id = \"header-account\"]//a[text()='My Account']")).click();
	  driver.findElement(By.xpath("//button[@title = 'Login']")).click();
	  String RequireEmail = driver.findElement(By.xpath("//div[@id = \"advice-required-entry-email\"]")).getText();
	  Assert.assertEquals(RequireEmail, "This is a required field.");
	  String RequirePass = driver.findElement(By.xpath("//div[@id = 'advice-required-entry-pass']")).getText();
	  Assert.assertEquals(RequirePass, "This is a required field.");
  }
  @Test
  public void  TC_02_LoginWithEmailInvalid() {
	  driver.get("http://live.guru99.com/index.php");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//span[@class='label' and text()='Account']")).click();
	  driver.findElement(By.xpath("//div[@id = \"header-account\"]//a[text()='My Account']")).click();
	  driver.findElement(By.id("email")).sendKeys("123@123.123");
	  driver.findElement(By.xpath("//button[@title = 'Login']")).click();
	  String validEmail = driver.findElement(By.id("advice-validate-email-email")).getText();
	  Assert.assertEquals(validEmail, "Please enter a valid email address. For example johndoe@domain.com.");
  }
  @Test
  public void  TC_03_LoginWithPasswordLessThan6Characters() {
	  driver.get("http://live.guru99.com/");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//div[@class='footer']//*[text()='My Account']")).click();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
	  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");
	  driver.findElement(By.xpath("//button[@title='Login']")).click();
	  String validatePassword = driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText();
	  Assert.assertEquals(validatePassword, "Please enter 6 or more characters without leading or trailing spaces.");
  }
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  
  }

  @AfterClass
  public void afterClass() {
  }

}
