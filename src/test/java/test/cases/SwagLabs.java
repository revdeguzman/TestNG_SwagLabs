package test.cases;

import java.time.Duration;

import org.apache.commons.collections4.Get;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.files.BaseFiles;

public class SwagLabs extends BaseFiles {
	
	      @Test(dataProvider = "testData")
		  public void TC001(String product) throws InterruptedException {
			
			//Add Item to Cart
			driver.findElement(By.id(product)).click();
			
			//Add to Cart
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
			
			//Click Checkout
			driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
			
			driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("Test First Name");
			driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Test Last Name");
			driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("Test Zip Code");
			driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
			
			//Click Finish
			driver.findElement(By.cssSelector("button[id='finish']")).click();
			
			//Click Home
			driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
			
			//Print
			System.out.println("Executed: Test Case 1: Sauce Labs Fleece Jacket");
			
		  }
	      
	      @Test(dataProvider = "testData")
		  public void TC002(String product) throws InterruptedException {
			
			//Add Item to Cart
			driver.findElement(By.id(product)).click();
			
	    	WebElement num_cart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
			int count_cart = Integer.parseUnsignedInt(num_cart.getText());
			
			if (count_cart >= 6) {
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
				
				//Click Checkout
				driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
				
				driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("Test First Name");
				driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Test Last Name");
				driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("Test Zip Code");
				driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
				
				//Click Finish
				driver.findElement(By.cssSelector("button[id='finish']")).click();
				
				//Click Home
				driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
				
				//Print
				System.out.println("Executed: Test Case 1: Sauce Labs Fleece Jacket");
			}
			
		  }
	      
	      @DataProvider(name = "testData")
	      public Object[] DataDriven() {
			
	    	  return new Object[]
	    	  {
	    		  "add-to-cart-sauce-labs-fleece-jacket",
	    		  "add-to-cart-sauce-labs-backpack",
	    		  "add-to-cart-sauce-labs-bolt-t-shirt",
	    		  "add-to-cart-test.allthethings()-t-shirt-(red)",
	    		  "add-to-cart-sauce-labs-bike-light",
	    		  "add-to-cart-sauce-labs-onesie"
	    	  };
	      }
}