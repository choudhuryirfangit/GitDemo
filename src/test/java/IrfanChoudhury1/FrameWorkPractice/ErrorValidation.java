package IrfanChoudhury1.FrameWorkPractice;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import IrfanChoudhury1.testComponenets.BaseTest;

public class ErrorValidation extends BaseTest {
	String UserID="irfan13@email.com";
	String PassKey="Irfan@12";
	String ProductName="IPHONE 13 PRO";
	String countryValue="ind";
	

	@Test
	public void submitOrder() throws IOException {

//		LandingPage landingpage=launchApplication();
		
//		LandingPage landingpage=new LandingPage(driver);
//		landingpage.goTo();
		landingpage.loginCredentials(UserID, PassKey);
		landingpage.getErrMsg();
		Assert.assertEquals(landingpage.getErrMsg(), "Incorrect email or password.");
		

	}

}
