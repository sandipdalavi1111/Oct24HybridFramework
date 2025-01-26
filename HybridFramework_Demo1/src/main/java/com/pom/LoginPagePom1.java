package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePom1 {
	@FindBy(id="username")
    private WebElement USERNAME; 
	
	@FindBy(id="password")
    private WebElement PASSWORD;
	
	@FindBy(id="submit")
    private WebElement SUBMIT;
	
	  public  LoginPagePom1(WebDriver driver) 
	     {
		     PageFactory.initElements(driver,this);
	     }
	     
	     public void userName(String un)    
	     {
	    	 USERNAME.sendKeys(un); //student         
	     }
	     public void password(String pw)    
	     {
	    	 PASSWORD.sendKeys(pw);          //Password123
	     }
	     public void submit()    
	     {
	    	 SUBMIT.click();         
	     }
}
