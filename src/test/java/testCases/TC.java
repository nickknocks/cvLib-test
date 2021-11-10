package testCases;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
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

	@Test(priority = 1, dataProvider = "datasender")
//	@Parameters({ "keywords", "location", "distance", "minSal", "maxSal",  "salType", "jobType" })
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
			home.selectSalaryType(test, salType);
//			home.selectJobType(test, jobType);
			home.clickFindJobs(test);
			test.getLogger().pass("Test has passed.");

		} catch (Throwable e) {
			test.getLogger().error("Error occured.");
			throw (e);
		} finally {
			test.tearDown();
		}
	}
	
	@DataProvider(name="datasender")
    public Object[][] sender()
    {
        Object[][]data = new Object[2][7];
        data[0][0] = "Selenium";
        data[0][1] = "London";
        data[0][2] = "up to 5 miles";
        data[0][3] = "30000";
        data[0][4] = "40000";
        data[0][5] = "Per annum";
        data[0][6] = "Any";
        data[1][0] = "Selenium";
        data[1][1] = "Glasglow";
        data[1][2] = "up to 5 miles";
        data[1][3] = "30000";
        data[1][4] = "40000";
        data[1][5] = "Per annum";
        data[1][6] = "Any";

        return data;
    }
	
	
	
}
