package test.cases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import base.files.BaseFiles;

public class InvalidCredentials extends BaseFiles {
	
	@Test
	public void VerifyError() {
		
		String actualErrorMessage = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
	    assertEquals("Epic sadface: Sorry, this user has been locked out.", actualErrorMessage);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

}