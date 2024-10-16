package test.cases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import base.files.BaseFiles;

public class SwagLabs extends BaseFiles {
	
	      @Test
		  public void TC001() throws InterruptedException {
			
			//Add Item to Cart
			driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
			
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
}