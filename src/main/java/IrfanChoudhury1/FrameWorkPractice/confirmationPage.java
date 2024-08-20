package IrfanChoudhury1.FrameWorkPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import IrfanChoudhury1.AbstractComponents.AbstractReusableComponents;

public class confirmationPage extends AbstractReusableComponents{

	WebDriver driver;
	public confirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
//	driver.findElement(By.cssSelector(".hero-primary"))
	@FindBy(css=".hero-primary")
	WebElement successMSG;
	
	public String getCnfmMsg() {
		String msg=successMSG.getText();
		return msg;
		
	}
	

}
