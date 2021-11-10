package applicationPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.Testing;

public class HomePage {

	@FindBy(id = "toggle-hp-search")
	private WebElement moreSearchOptionToggler;

	public void toggleSearchOptions(Testing test) {
		test.myFunctions().click(test, moreSearchOptionToggler);
		test.getLogger().info("Clicked More Search.");
	}
//	-----------------------------------------------------------------------------------

	@FindBy(id = "keywords")
	private WebElement textBox_keywords;

	public void enterKeywords(Testing test, String keywords) {
		test.myFunctions().type(test, textBox_keywords, keywords);
		test.getLogger().info("Enterred keywords.");
	}
//	-----------------------------------------------------------------------------------

	@FindBy(id = "location")
	private WebElement textBox_Location;

	public void enterLocation(Testing test, String location) {
		test.myFunctions().type(test, textBox_Location, location);
		test.getLogger().info("Entered location.");
	}
//	-----------------------------------------------------------------------------------

	@FindBy(id = "distance")
	private WebElement dropdown_Distance;

	public void selectDistance(Testing test, String distance) {
		test.myFunctions().dropdown(test, dropdown_Distance, distance);
		test.getLogger().info("Entered distance");
	}
//	-----------------------------------------------------------------------------------

	@FindBy(id = "salarymin")
	private WebElement textBox_MinSalary;

	public void enterMinSalary(Testing test, String minSalary) {
		test.myFunctions().type(test, textBox_MinSalary, minSalary);
		test.getLogger().info("Entered min salary");
	}

//	-----------------------------------------------------------------------------------

	@FindBy(id = "salarymax")
	private WebElement textBox_MaxSalary;

	public void enterMaxSalary(Testing test, String maxSalary) {
		test.myFunctions().type(test, textBox_MaxSalary, maxSalary);
		test.getLogger().info("Entered max salary.");
	}

//	-----------------------------------------------------------------------------------

	@FindBy(id = "salarytype")
	private WebElement dropdown_SalaryType;

	public void selectSalaryType(Testing test, String salaryType) {

//			test.myFunctions().staticWait(4000);
			test.myFunctions().dropdown(test, dropdown_SalaryType, salaryType);
			test.getLogger().info("Selected salary type");

//		WebElement option = test.driver
//				.findElement(By.xpath("//*[@id=\"salarytype\"]/option[text()='" + salaryType + "']"));
//		test.myFunctions().click(test, dropdown_SalaryType);
//		test.myFunctions().staticWait(2000);
//		test.myFunctions().clickJS(test, option);

	}

//	-----------------------------------------------------------------------------------

	@FindBy(id = "jobType")
	private WebElement dropdown_JobType;

	public void selectJobType(Testing test, String jobType) {
		test.myFunctions().dropdown(test, dropdown_JobType, jobType);
		test.getLogger().info("selected job type");
	}

//	-----------------------------------------------------------------------------------

	@FindBy(id = "hp-search-btn")
	private WebElement button_FindJobs;

	public void clickFindJobs(Testing test) {
		test.myFunctions().click(test, button_FindJobs);
		test.getLogger().info("Clicked on Find Job.");
		WebDriverWait wait = new WebDriverWait(test.driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.titleContains("Jobs"));
		test.getLogger().pass("Landed on Search Rersult page.");
	}
}
