package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LinkedinValidationsMultipleAnnotations {

	WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver(); // Open Browser
		driver.manage().window().maximize(); // Maximize window
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // Use Implicitly Wait
		driver.get("https://www.linkedin.com/"); // Navigate to URL

	}

	@Test
	public void verifyTitle() {
		String expectedTitle = "LinkedIn: Log In or Sign Up";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test
	public void verifyText() {
		String expectedText = "Be great at what you do";
		String actualText = driver.findElement(By.cssSelector("#regForm > h2")).getText();
		Assert.assertEquals(actualText, expectedText);
	}

	@Test
	public void verifySinInBtnVisibility() {
		boolean signInBtnVisibleOrNot = driver.findElement(By.id("login-submit")).isDisplayed();
		Assert.assertTrue(signInBtnVisibleOrNot);
	}

	@Test
	public void verifySingInBtnEnable() {
		boolean singInBtnEnabledOrNot = driver.findElement(By.id("login-submit")).isEnabled();
		Assert.assertFalse(singInBtnEnabledOrNot);
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();

	}
}
