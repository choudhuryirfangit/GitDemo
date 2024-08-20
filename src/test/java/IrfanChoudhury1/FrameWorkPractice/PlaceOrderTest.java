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

public class PlaceOrderTest extends BaseTest {
	String UserID="irfan123@email.com";
	String PassKey="Irfan@123";
	String ProductName="IPHONE 13 PRO";
	String countryValue="ind";
	

	@Test
	public void submitOrder() throws IOException {

//		LandingPage landingpage=launchApplication();
		
//		LandingPage landingpage=new LandingPage(driver);
//		landingpage.goTo();
		productCatalogues productCat=landingpage.loginCredentials(UserID, PassKey);

//		productCatalogues productCat=new productCatalogues(driver);
		productCat.getProductList();
		productCat.getProductByName(ProductName);
		productCat.addToCart(ProductName);
		CartPage cartpage=productCat.goTocartPage();
		
//		CartPage cartpage=new CartPage(driver);
		Boolean match=cartpage.verifyCartProduct(ProductName);
		assertTrue(match);
		
		CheckoutPage checkoutpage=cartpage.goTOCheckoutPage();
//		CheckoutPage checkoutpage=new CheckoutPage(driver);
		checkoutpage.passCountryValue();
		checkoutpage.selectCountry();
		confirmationPage cP=checkoutpage.goToCnfrmPage();

//		confirmationPage cP=new confirmationPage(driver);
		String successMsg=cP.getCnfmMsg();
		Assert.assertTrue(successMsg.equalsIgnoreCase("Thankyou for the order."));
		
//		driver.quit();	

	}

}
