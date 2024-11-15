package test.cases;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.files.BaseFiles;
import base.files.Screenshot;
import file.reader.ReadExcel;

public class SwagLabs extends BaseFiles {

	@Test(dataProviderClass = ReadExcel.class, dataProvider = "excelData")
	public void EndToEnd(String headerName, String cart_item, String firstName, String lastName, String postalCode,
			String checkout_header, String order_confrim_header) throws InterruptedException, IOException {

		//Add Screenshot
		Screenshot screenshot = new Screenshot();
		String folderPath = System.getProperty("user.dir") + "\\Screenshots\\Passed\\";
		
		// Validate Home Page Header
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		String header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("app_logo"))).getText();

		// Verify if Header is match
		Assert.assertEquals(header, headerName);
		
		//Get the Item Name
		String textDisplayed = cart_item;
		
		// Add item to cart based on the displayed text
		ItemSelected(textDisplayed);
		
		// Add to Cart
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("shopping_cart_container")).click();

		// Validate Cart Description
		String description = driver.findElement(By.className("inventory_item_name")).getText();
		Assert.assertEquals(description, cart_item);
		
		//Screenshot
		screenshot.FullPageScreenShot(folderPath);

		// Click Checkout
		driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();

		// Input Customer Info
		driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys(firstName);
		driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys(lastName);
		driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys(postalCode);
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();

		// Validate Cart Description
		String chck_head = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item_name"))).getText();
		// Verify if Checkout Header is match
		Assert.assertEquals(chck_head, checkout_header);

		// Click Finish
		driver.findElement(By.cssSelector("button[id='finish']")).click();

		// Validate Complete Order
		String order_confirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-header"))).getText();
		// Verify if Checkout Header is match
		Assert.assertEquals(order_confirm, order_confrim_header);

		// Click Home
		driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();

	}

	@DataProvider(name = "excelData")
	public void ItemSelected(String itemName) {

		// Condition if Text is displayed
		switch (itemName) {
		case "Sauce Labs Backpack":
			// Add Item to Cart
			driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
			break;
		case "Sauce Labs Bike Light":
			// Add Item to Cart
			driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
			break;
		case "Sauce Labs Bolt T-Shirt":
			// Add Item to Cart
			driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
			break;
		case "Sauce Labs Fleece Jacket":
			// Add Item to Cart
			driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
			break;
		case "Sauce Labs Onesie":
			// Add Item to Cart
			driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
			break;
		case "Test.allTheThings() T-Shirt (Red)":
			// Add Item to Cart
			driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
			break;
		default:
			System.out.println(itemName + " Item not Found.");
		}
	}
}