package applicationPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.Testing;

public class HomePage {

	@FindBy(id = "toggle-hp-search")
	private WebElement moreSearchOptionToggler;

	public void toggleSearchOptions(Testing test) {
		test.myFunctions().click(test, moreSearchOptionToggler);
		test.getLogger().info("");
	}
//	-----------------------------------------------------------------------------------

	@FindBy(id = "keywords")
	private WebElement textBox_keywords;

	public void enterKeywords(Testing test, String keywords) {
		test.myFunctions().type(test, textBox_keywords, keywords);
		test.getLogger().info("");
	}
//	-----------------------------------------------------------------------------------

	@FindBy(id = "location")
	private WebElement textBox_Location;

	public void enterLocation(Testing test, String location) {
		test.myFunctions().type(test, textBox_Location, location);
		test.getLogger().info("");
	}
//	-----------------------------------------------------------------------------------

	@FindBy(id = "distance")
	private WebElement dropdown_Distance;

	public void selectDistance(Testing test, String distance) {
		test.myFunctions().dropdown(test, dropdown_Distance, distance);
		test.getLogger().info("");
	}
//	-----------------------------------------------------------------------------------

	@FindBy(id = "salarymin")
	private WebElement textBox_MinSalary;

	public void enterMinSalary(Testing test, String minSalary) {
		test.myFunctions().type(test, textBox_MinSalary, minSalary);
		test.getLogger().info("");
	}

//	-----------------------------------------------------------------------------------

	@FindBy(id = "salarymax")
	private WebElement textBox_MaxSalary;

	public void enterMaxSalary(Testing test, String maxSalary) {
		test.myFunctions().type(test, textBox_MaxSalary, maxSalary);
		test.getLogger().info("");
	}

//	-----------------------------------------------------------------------------------

	@FindBy(id = "salarytype")
	private WebElement dropdown_SalaryType;

	public void selectSalaryType(Testing test, String salaryType) {
		try {
			test.myFunctions().staticWait(4000);
			test.myFunctions().type(test, dropdown_SalaryType, salaryType);
			test.getLogger().info("Selected salary type");
		} catch (Exception e) {
			test.getLogger().error("Exception occured while selecting Salary type");
		}

	}

//	-----------------------------------------------------------------------------------

	@FindBy(id = "jobType")
	private WebElement dropdown_JobType;

	public void selectJobType(Testing test, String jobType) {
		test.myFunctions().type(test, dropdown_JobType, jobType);
		test.getLogger().info("");
	}

//	-----------------------------------------------------------------------------------

	@FindBy(id = "hp-search-btn")
	private WebElement button_FindJobs;

	public void clickFindJobs(Testing test) {
		test.myFunctions().click(test, button_FindJobs);
		test.getLogger().info("");
	}
}
