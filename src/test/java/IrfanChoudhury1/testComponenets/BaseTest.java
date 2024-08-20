package IrfanChoudhury1.testComponenets;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import IrfanChoudhury1.FrameWorkPractice.LandingPage;

public class BaseTest {
	
	WebDriver driver;
	public LandingPage landingpage;
	
	public WebDriver invokeDriver() throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\IrfanChoudhury1\\Resources\\GlobalData.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
			}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	@BeforeMethod
	public LandingPage launchApplication() throws IOException { 
		driver=invokeDriver();
		landingpage=new LandingPage(driver);
		landingpage.goTo();
		return landingpage;
	}
	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}
	

}
