package IrfanChoudhury1.FrameWorkPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import IrfanChoudhury1.AbstractComponents.AbstractReusableComponents;

public class CartPage extends AbstractReusableComponents{

	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
//	List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
//	driver.findElement(By.cssSelector(".totalRow button")).click();
	@FindBy(css=".totalRow button")
	WebElement checkoutBtn;
	
	public Boolean verifyCartProduct(String ProductName) {
		Boolean match= cartProducts.stream().anyMatch(s->s.getText().equals(ProductName));
		return match;
	}
	public CheckoutPage goTOCheckoutPage() {
		checkoutBtn.click();
		return new CheckoutPage(driver);
	}

}
