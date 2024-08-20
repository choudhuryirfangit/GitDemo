package IrfanChoudhury1.FrameWorkPractice;

import static org.testng.Assert.assertTrue;

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

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.findElement(By.id("userEmail")).sendKeys("irfan123@email.com");
		driver.findElement(By.id("userPassword")).sendKeys("Irfan@123");
		driver.findElement(By.id("login")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> productCards= driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement product=productCards.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals("IPHONE 13 PRO")).findFirst().orElse(null);
		product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-message")));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		
		
		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
		
		List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match=cartProducts.stream().anyMatch(s->s.getText().equals("IPHONE 13 PRO"));
		assertTrue(match);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		Actions a=new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "Ind").build().perform();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		List<WebElement> countrySearch=driver.findElements(By.cssSelector(".ta-results button"));
		
		WebElement country=countrySearch.stream().filter(s->s.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
		country.click();
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String successMsg=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(successMsg.equalsIgnoreCase("Thankyou for the order."));
		
		driver.quit();
		
		
		
		
		

	}

}
