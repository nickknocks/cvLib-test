package testNGListeners;

import java.io.CharArrayWriter;
import java.io.PrintWriter;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestAnnotation implements ITestListener {

	Logger log = Logger.getLogger("Test Suite");

	// ------------------------------------------------------------------------------------------
	@Override
	public void onFinish(ITestContext arg0) {
		log.info("The test is completed for all the cases.");
	}

	// ------------------------------------------------------------------------------------------
	@Override
	public void onStart(ITestContext arg0) {
	}

	// ------------------------------------------------------------------------------------------
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	// ------------------------------------------------------------------------------------------

	@Override
	// FAILED
	public void onTestFailure(ITestResult arg0) {
		// Getting Error Message in LOG
		CharArrayWriter cw = new CharArrayWriter();
		PrintWriter w = new PrintWriter(cw);
		arg0.getThrowable().printStackTrace(w);
		w.close();
		String trace = cw.toString();
		log.error(arg0.getName() + " is Failed ! \n EXCEPTION:  --->  " + trace);

	}

	// ------------------------------------------------------------------------------------------

	@Override
	public void onTestSkipped(ITestResult arg0) {
	}

	// ------------------------------------------------------------------------------------------

	@Override
	public void onTestStart(ITestResult arg0) {


	}

	// ------------------------------------------------------------------------------------------

	@Override
	// PASSED
	public void onTestSuccess(ITestResult arg0) {
	}
}
