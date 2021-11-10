package resources;

import org.openqa.selenium.WebDriver;

public class Testing {
	public WebDriver driver;
	private Class page;
	private TestData td;
	private BrowserFactory bf;
	private MyFunctions myFunctions;
	private Report reporter;
	public int vehicleCount;
	public int addedVehicle = 0;
	public int driverCount;
	public int addedDriver = 0;
	public String leadName;

	// CONSTRUCTOR
	public Testing(String scriptName) {
		reporter = new Report(scriptName);
		myFunctions = new MyFunctions();
		bf = new BrowserFactory("https://www.cv-library.co.uk");
		driver = bf.driver;

//		3. INITIALING CURRENT PAGE TO NULL
		page = null;
	}

	// GETTERs and SETTERs FOR PAGE:
	public Class getPage() {
		return page;
	}

	public void setPage(Class page) {
		this.myFunctions.staticWait(1500);
		String title = this.driver.getTitle();
		this.getLogger().info("Landed on page: " + title);
		this.page = page;
	}

	// ---------------------------------------------------------------------
//	TEAR DOWN FOR TESTCASE:
	public void tearDown() {
		bf.closeBrowser();
		reporter.flush();
	}

	// ---------------------------------------------------------------------
	public MyFunctions myFunctions() {
		return myFunctions;
	}

//	---------------------------------------------------------------------
	public Report getLogger() {
		return reporter;
	}

}