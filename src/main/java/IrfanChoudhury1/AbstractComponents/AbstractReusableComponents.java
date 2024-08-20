package IrfanChoudhury1.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import IrfanChoudhury1.FrameWorkPractice.CartPage;

public class AbstractReusableComponents{
	
	WebDriver driver;
	public AbstractReusableComponents(WebDriver driver) {
		this.driver=driver;
	}
//	driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement cartBtn;
	
	

	public void waitForElementToAppear(By findBy) {
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitForElementToDisappear(By findBy) {
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	public void waitForElementToAppear(WebElement findBy) {
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(findBy));

}
	public CartPage goTocartPage() {
		cartBtn.click();
		CartPage cartpage=new CartPage(driver);
		return cartpage;
	}
}
