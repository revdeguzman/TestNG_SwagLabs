package base.files;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseFiles {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static Properties cus = new Properties();
	public static FileReader file;
	
	@BeforeTest
	public void setUp() throws IOException {
		
		if(driver == null) {
			
			//Create new object that locate properties file
			FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config_files\\config.properties");
			FileReader file2 = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config_files\\login_page.properties");
			FileReader file3 = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config_files\\customer.properties");
			
			//Read properties File
			prop.load(file);
			loc.load(file2);
			cus.load(file3);
		}
		
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			//Set up Chrome Driver
			WebDriverManager.chromedriver().setup();
			
			//Create Chrome Object
			driver = new ChromeDriver();
			
			//Maximize Browser
			driver.manage().window().maximize();
			
			//Delete Cookies from the browser.
			driver.manage().deleteAllCookies();

			//Set URL to the Browser
			driver.get(prop.getProperty("testurl"));
			
			//Wait for the elements to load.
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			//Input User name and Password
			driver.findElement(By.xpath(loc.getProperty("xpath_username"))).sendKeys(loc.getProperty("username"));
			driver.findElement(By.xpath(loc.getProperty("xpath_password"))).sendKeys(loc.getProperty("password"));
			
			//Click Login
			driver.findElement(By.xpath(loc.getProperty("xpath_login_button"))).click();
			
		}
		
		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			
				//Set up Firefox Driver
				WebDriverManager.firefoxdriver().setup();
				
				//Create Firefox Object
				driver = new FirefoxDriver();
				
				//Maximize Browser
				driver.manage().window().maximize();
				
				//Delete Cookies from the browser.
				driver.manage().deleteAllCookies();

				//Set URL to the Browser
				driver.get(prop.getProperty("testurl"));
				
				//Wait for the elements to load.
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				//Input User name and Password
				driver.findElement(By.xpath(loc.getProperty("xpath_username"))).sendKeys(loc.getProperty("username"));
				driver.findElement(By.xpath(loc.getProperty("xpath_password"))).sendKeys(loc.getProperty("password"));
				
				//Click Login
				driver.findElement(By.xpath(loc.getProperty("xpath_login_button"))).click();
		}
		
		else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
			
			//Set up Edge Driver
			WebDriverManager.edgedriver().setup();
			
			//Create Edge Object
			driver = new EdgeDriver();
			
			//Maximize Browser
			driver.manage().window().maximize();
			
			//Delete Cookies from the browser.
			driver.manage().deleteAllCookies();

			//Set URL to the Browser
			driver.get(prop.getProperty("testurl"));
			
			//Wait for the elements to load.
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			//Input User name and Password
			driver.findElement(By.xpath(loc.getProperty("xpath_username"))).sendKeys(loc.getProperty("username"));
			driver.findElement(By.xpath(loc.getProperty("xpath_password"))).sendKeys(loc.getProperty("password"));
			
			//Click Login
			driver.findElement(By.xpath(loc.getProperty("xpath_login_button"))).click();
	}
}
	
	@AfterTest
	public void closeBrowser() throws InterruptedException {
		
		if(driver != null) {
			
		//Menu is Clicked.
		driver.findElement(By.id("react-burger-menu-btn")).click();
		
		//Menu - Logout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Click Logout
		driver.findElement(By.id("logout_sidebar_link")).click();
				
		//Close Browser
		driver.close();
		
		//Quit the Drivers
		driver.quit();
		
		} else {
		
			System.out.println("value of driver is = " + driver);
		}
		
	}
	
}