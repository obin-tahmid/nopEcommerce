package UtilityFunctions;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseTest.BaseTest;

public class TestListeners extends BaseTest implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onTestStart(ITestResult result) {

		/*Adding test information to the extent report*/
		
		Method method = result.getMethod().getConstructorOrMethod().getMethod();
		Test annotation = method.getAnnotation(Test.class);
		String description = annotation.description();
		String[] groups = result.getMethod().getGroups();
		setExtentTest(
				extent.createTest(result.getMethod().getMethodName() + ": " + " [" + groups[0] + "] " + description));

		getExtentTest().log(Status.INFO, "Landed on Homepage: ");

		getUtil().print(
				"Device: Android executing " + result.getTestClass() + ": " + result.getMethod().getMethodName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		getExtentTest().fail(result.getThrowable());

		// Takes Screenshot of the failed test cases at the point of failure
		new ScreenshotUtil().screenshotSaveAndEmbed(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		getExtentTest().pass(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// checking if current TestMethod is dependent on some other method
		/*
		 * retryAnalyzer implementation was skipped as this is not required for the 2
		 * scenario task
		 */
		
		if (result.getMethod().getMethodsDependedUpon().length != 0 && result.wasRetried() == false) {

			getExtentTest().log(Status.SKIP, "Test Skipped due to dependencies: "
					+ Arrays.toString(result.getMethod().getMethodsDependedUpon()));

		} else if (result.wasRetried()) {

			getExtentTest().log(Status.SKIP, "Test Skipped");

			extent.removeTest(getExtentTest());

		}

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
