package com.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pom.LoginPagePom1;
import com.utility.Base;
import com.utility.ExcelDataProvider;
import com.utility.Screenshot;

import io.github.bonigarcia.wdm.WebDriverManager;



public class VerifyLoginPage extends Base {

//	WebDriver driver;
	LoginPagePom1 lp = new LoginPagePom1(driver);
	ExcelDataProvider edp = new ExcelDataProvider();
	
	 @BeforeTest
	  @Parameters({"Browser"})
	  public void browserLaunch(String browser) {//chrome
		  //chrome
		 if(browser.equalsIgnoreCase("chrome")) {
			 driver=new ChromeDriver();
		 }
		 else if(browser.equalsIgnoreCase("firefox")) {//firefox
			 driver=new FirefoxDriver();
		 }
			// driver = new ChromeDriver();
			 
			 driver.get("https://practicetestautomation.com/practice-test-login/");
			
			 driver.manage().window().maximize();
	  }

	@Test(priority=0)
	public void user_enters_username_and_password() throws IOException {
		edp = new ExcelDataProvider();
		edp.getData();
		
		String uname = edp.getStringData("Sheet1",2,2);
		
		lp = new LoginPagePom1(driver);
		lp.userName(uname);//student
		
		String pass = edp.getStringData("Sheet1",3,2);
		lp = new LoginPagePom1(driver);
		lp.password(pass);
		
		System.out.println("Entered the username and password");
	}

	@Test(priority=1)
	public void click_on_login_button() {
	   lp = new LoginPagePom1(driver);
	   lp.submit();
		System.out.println("Click on the submit button");
	}

	@Test(priority=2)
	public void user_is_navigate_to_the_homepage() throws InterruptedException {
	   
		String url = driver.getCurrentUrl();
		if(url.equals("https://practicetestautomation.com/logged-in-successfully/"))
		{
			System.out.println("Test case is passed");
		}
		else 
		{
			System.out.println("Test case is failed");
		}
		System.out.println("Navigate to the home page");
		Thread.sleep(4000);
		
		driver.close();
	}
	
	@Test(priority=3)
	public void abc() {
		Assert.assertEquals("abc", "abc");
	}

	 @AfterMethod
	  public void failedScreenshot(ITestResult result) throws IOException
	 	{
		  
		  if(ITestResult.FAILURE ==result.getStatus())
		  {
			  
			  Screenshot.getScreenshot(driver);
		  }
		 
		  
	 	}

}
