package resources;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class MyFunctions {

	// ======================================================================

	public void type(Testing test, WebElement element, String value) {
		WebDriverWait wait = new WebDriverWait(test.driver, Duration.ofSeconds(15));
		Boolean done = false;
		int attempt = 0;
		done = false;
		while (!done && (attempt <= 3)) {
			try {
				attempt++;
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.clear();
				element.sendKeys(value);
				done = true;
			}

			catch (StaleElementReferenceException e) {
				if (attempt <= 3)
					reInitPageElements(test);
				else
					throw e;
			}

			catch (WebDriverException e) {
				if (attempt <= 3) {
//					((JavascriptExecutor) test.driver).executeScript("return document.getElementById('select id here').selectedIndex = '2'");
					test.getLogger().error("WebDriver Exception");
					staticWait(3000);
				} else
					throw e;
			}
		}
	}

// ------------------------------------------------------------------------------

	public void click(Testing test, WebElement element) {
		WebDriverWait wait = new WebDriverWait(test.driver, Duration.ofSeconds(15));
		Boolean done = false;
		int attempt = 0;
		done = false;
		attempt = 0;
		while (!done && (attempt <= 3)) {
			try {
				attempt++;
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				done = true;
			}

			catch (StaleElementReferenceException e) {
				if (attempt <= 3)
					reInitPageElements(test);
				else
					throw e;
			}

			catch (WebDriverException e) {
				if (attempt <= 3) {
					test.getLogger().error("WebDriver Exception");
					staticWait(3000);
				} else
					throw e;
			}

		}
	}

//	======================================================================

	public void dropdown(Testing test, WebElement element, String value) {
		WebDriverWait wait = new WebDriverWait(test.driver, Duration.ofSeconds(15));
		Boolean done = false;
		int attempt = 0;
		done = false;
		attempt = 0;
		while (!done && (attempt <= 3)) {
			try {
				attempt++;
				wait.until(ExpectedConditions.elementToBeClickable(element));
				Select select = new Select(element);
				select.selectByVisibleText(value);
				done = true;
			}

			catch (StaleElementReferenceException e) {
				if (attempt <= 3)
					reInitPageElements(test);
				else
					throw e;
			}

			catch (WebDriverException e) {
				if (attempt <= 3) {
					test.getLogger().error("WebDriver Exception");
					staticWait(2000);
					
				} else
					throw e;
			}
		}
	}

//	-------------------------------------------------------------------------------

	// RE-INITIALIZE PAGE ELEMENTS
	public void reInitPageElements(Testing test) {
		test.getLogger().error("Stale Element Exception");
		staticWait(1000);
		PageFactory.initElements(test.driver, test.getPage());
	}

//	-------------------------------------------------------------------------------	

	public void staticWait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void clickJS(Testing test, WebElement element) {
		((JavascriptExecutor) test.driver).executeScript("arguments[0].click();", element);
	}
	

}
