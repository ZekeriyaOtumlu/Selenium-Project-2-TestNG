package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyTitle {
	
	WebDriver driver; // We use it here because we want to make as GLOBAL driver
	
	@BeforeTest
	public void openBrowser() {//Method
		System.setProperty("webdriver.chromedriver", "chromedriver.exe");
		driver = new ChromeDriver(); // Open Browser method create object
		driver.get("https://facebook.com");
	}
	
	@Test
	public void titleVerification() { // method 
		String expectedTitle = "Facebook - Log In or Sign Up"; // we will get it with functional Requirements
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle); // we use if (expectedTitle.equals(actualTitle){..... else{.... Now We use Assert
	}
	
	@AfterTest
	public void closeBrowser() {// method
		driver.close(); 
	}
	
	
	

}
