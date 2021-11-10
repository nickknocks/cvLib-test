 package resources;

import java.io.IOException;

import org.apache.log4j.Logger;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Report{
	
/*	Dear Examiner,
 * This class is a combined class for Extent Report and Log4j.
 * It creates a common (static) report for all the test cases.
 * Simultaneously, it prints log on console from single input.*/
	
//	Creates a static extent report and a non-static logger for each TC:
	private static ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\log\\Report.html");
	private static ExtentReports extent = new ExtentReports();
	private ExtentTest log;
	
//	Declares an object of log4j:
	private Logger log4j;
	
	//CONSTRUCTOR:
	Report (String scriptName) {
		log4j = Logger.getLogger(scriptName);
		extent.attachReporter(reporter);
		log = extent.createTest(scriptName);
	}
	
	//	FLUSH:
	public void flush() {
		extent.flush();
	}
	
	public void info(String message) {
		log4j.info(message);
		log.info(message);
	}
	
	public void error(String message) {
		log4j.error(message);
	}
	
	public void warn(String message) {
		log4j.warn(message);
	}
	
	public void fatal(String message) {
		log4j.fatal(message);
		log.fatal(message);
	}
	
	public void pass(String message) {
		log4j.info(message);
		log.pass(message);
	}
	
	public void fail(String message) {
		log4j.fatal(message);
		log.fail(message);
	}
	
	public void skip(String message) {
		log.skip(message);
	}
	
	public void captureScreenshot(String path) {
		try {
			log.addScreenCaptureFromPath(path, "Screenshot:");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}