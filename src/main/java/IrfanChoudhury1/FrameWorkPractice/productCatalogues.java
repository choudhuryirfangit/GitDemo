package IrfanChoudhury1.FrameWorkPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import IrfanChoudhury1.AbstractComponents.AbstractReusableComponents;

public class productCatalogues extends AbstractReusableComponents{
	By findByProducts=By.cssSelector(".mb-3");
	By addToCartBtn=By.cssSelector(".card-body button:last-of-type");
	By toastMsg=By.cssSelector(".toast-message");
	By spinner=By.cssSelector(".ng-animating");

	WebDriver driver;
	public productCatalogues(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	By.cssSelector(".mb-3")
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
//	By.cssSelector(".card-body button:last-of-type")).click();
//	driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
	
	

	
	public List<WebElement> getProductList() {
		waitForElementToAppear(findByProducts);
		return products;
		
	}
	public WebElement getProductByName(String ProductName) {
		WebElement product=products.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
		return product;
	}
	public void addToCart(String ProductName) {
		WebElement prod=getProductByName(ProductName);
		prod.findElement(addToCartBtn).click();
		waitForElementToAppear(toastMsg);
//		waitForElementToDisappear(spinner);

	}
}
