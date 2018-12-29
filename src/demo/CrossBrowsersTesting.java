package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowsersTesting {
	WebDriver driver;

	
	@BeforeTest
	@Parameters("browser") // We use it for parameters browsers
	public void openBrowser(String browser)  {

		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}
//		else if (browser.equals("FireFox")) {
//			System.setProperty("webdriver.gecko.driver", "geckodriver.exe"); // Set property because first time i am using firefox browser
//			driver = new FireFoxDriver();
//		}
		else if (browser.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", "MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
//		} else if (browser.equals("Internet Explorer")) {
//			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
//			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.linkedin.com/");
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
