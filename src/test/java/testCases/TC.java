package testCases;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import applicationPages.HomePage;
import resources.Testing;

public class TC {
	private final String brandName = "Elephant";

	// ==============================================================================================
	// *** ADDITIONAL METHODS ***

	@BeforeSuite
	public void beforeSuite() {
		PropertyConfigurator.configure("log4j.properties");
	}

	@Test(priority = 1)
	@Parameters({ "keywords", "location", "distance", "minSal", "maxSal",  "salType", "jobType" })
	public void searchJobs(String keywords, String location, String distance, String minSal, String maxSal, String salType, String jobType ) {
		Testing test = new Testing("Search Jobs on CVL");
		try {
			test.setPage(HomePage.class);
			HomePage home = (HomePage) PageFactory.initElements(test.driver, test.getPage());
			home.toggleSearchOptions(test);
			home.enterKeywords(test, keywords);
			home.enterLocation(test, location);
			home.selectDistance(test, distance);
			home.enterMinSalary(test, minSal);
			home.enterMaxSalary(test, maxSal);
			home.selectSalaryType(test, jobType);
			home.selectJobType(test, jobType);
			home.clickFindJobs(test);
			
			

		} catch (Throwable e) {
			
			throw (e);
		} finally {
			test.tearDown();
		}
	}

}
