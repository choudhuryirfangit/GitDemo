package IrfanChoudhury1.FrameWorkPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Salesforce_SatndAlone {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://choudhuryindustries-dev-ed.my.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("choudhuryirfan@salesforce.com");
		driver.findElement(By.id("password")).sendKeys("lexus@1999IR");
		driver.findElement(By.id("Login")).click();
		
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@title='App Launcher']"))));
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@class='slds-input']"))));
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("sales");
		WebElement element = driver.findElement(By.xpath("//a[@data-label='Sales Console']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@title='Show Navigation Menu']"))));
		driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
		driver.findElement(By.xpath("//span[text()='Leads']")).click();
		
//		Create Lead
		driver.findElement(By.xpath("//div[@title='New']")).click();
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='actionBody']"))));
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Choudhury");
		driver.findElement(By.xpath("//input[@name='Company']")).sendKeys("CTS");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
//		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='actionBody']"))));
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
//		driver.findElement(By.xpath("//span[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[@data-label='Contacts']")).click();
		driver.findElement(By.xpath("//a[@title='Contacts']")).click();
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Choudhury");
		driver.findElement(By.xpath("//input[@name='Phone']")).sendKeys("8014556432");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		
		driver.quit();
		

		
		

	}
	}


