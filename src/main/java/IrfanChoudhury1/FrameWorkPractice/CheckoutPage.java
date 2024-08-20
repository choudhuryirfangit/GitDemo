package IrfanChoudhury1.FrameWorkPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import IrfanChoudhury1.AbstractComponents.AbstractReusableComponents;

public class CheckoutPage extends AbstractReusableComponents{
	By countrysugg=By.cssSelector(".ta-results");

	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
//	By.xpath("//input[@placeholder='Select Country']")
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement countryBox;
	
//	By.cssSelector(".ta-results")
//	List<WebElement> countrySearch=driver.findElements(By.cssSelector(".ta-results button"));
	@FindBy(css=".ta-results button")
	List<WebElement> countrySearchResults;
	
//	driver.findElement(By.cssSelector(".action__submit")).click();
	@FindBy(css=".action__submit")
	WebElement submitOrder;

	
	public void passCountryValue() {
		Actions a=new Actions(driver);
		a.sendKeys(countryBox, "Ind").build().perform();
		waitForElementToAppear(countrysugg);
	}
	public void selectCountry() {
		WebElement country=countrySearchResults.stream().filter(s->s.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
		country.click();
	}
	public confirmationPage goToCnfrmPage() {
		submitOrder.click();
		return new confirmationPage(driver);
	}
	

}
