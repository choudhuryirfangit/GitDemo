package IrfanChoudhury1.FrameWorkPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import IrfanChoudhury1.AbstractComponents.AbstractReusableComponents;

public class LandingPage extends AbstractReusableComponents{
	
	public WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
//	WebElement userEmail=driver.findElement(By.id("userEmail"));
	@FindBy(id="userEmail")
	WebElement UserName;
	
//	driver.findElement(By.id("userPassword")).sendKeys("Irfan@123");
	@FindBy(id="userPassword")
	WebElement password;
	
//	driver.findElement(By.id("login")).click();
	@FindBy(id="login")
	WebElement loginBtn;
	
	@FindBy(css=".toast-message")
	WebElement errMsg;
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
		
	}
	public productCatalogues loginCredentials(String userName,String Password) {
		UserName.sendKeys(userName);
		password.sendKeys(Password);
		loginBtn.click();
		productCatalogues productCat=new productCatalogues(driver);
		return productCat;
	}
	
	public String getErrMsg() {
		waitForElementToAppear(errMsg);
		return errMsg.getText();
		
	}
	
	

}
