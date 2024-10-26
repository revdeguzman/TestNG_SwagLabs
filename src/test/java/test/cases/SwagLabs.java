package test.cases;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.files.BaseFiles;
import base.files.Screenshot;
import file.reader.ReadExcel;

public class SwagLabs extends BaseFiles {

	      @Test(dataProviderClass = ReadExcel.class, dataProvider = "excelData")
		  public void EndToEnd(String headerName, String cart_item, String firstName, String lastName, String postalCode, String checkout_header, String order_confrim_header) throws InterruptedException, IOException {
	    	
	    	//Screenshot
		    Screenshot sshot = new Screenshot();
	    	
	    	// Validate Home Page Header
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    	String header =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("app_logo"))).getText();
	    	
	    	//Screenshot
	    	sshot.FullPageScreenShot();
	    	
			//Verify if Header is match
			Assert.assertEquals(header, headerName);
			
			//Add Item to Cart
			driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
			
			//Add to Cart
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
			
			//Validate Cart Description
			String description = driver.findElement(By.className("inventory_item_name")).getText();
			Assert.assertEquals(description, cart_item);

	    	//Click Checkout
			driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
	    	 
	    	//Input Customer Info
			driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys(firstName);
			driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys(lastName);
			driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys(postalCode);
			driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
			
			//Validate Cart Description
			String chck_head = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item_name"))).getText();
			//Verify if Checkout Header is match
	    	Assert.assertEquals(chck_head, checkout_header);
	    	
	    	//Screenshot
	    	sshot.FullPageScreenShot();
	    	  
	    	//Click Finish
			driver.findElement(By.cssSelector("button[id='finish']")).click();
			
			//Validate Cart Description
			String order_confirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-header"))).getText();
			//Verify if Checkout Header is match
			Assert.assertEquals(order_confirm, order_confrim_header);
			
			//Screenshot
	    	sshot.FullPageScreenShot();

	    	//Click Home
			driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
			
	      }
}