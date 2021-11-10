package resources;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	public WebDriver driver;

	// CONSTRUCTOR
	BrowserFactory(String url) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);

	}

	// ------------------------------------------------------------------------------------------

	public void closeBrowser() {
		driver.close();
		driver.quit();
	}

}
