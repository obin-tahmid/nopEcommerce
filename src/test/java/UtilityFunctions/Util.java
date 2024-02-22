package UtilityFunctions;

import java.awt.Dimension;
import java.time.Duration;
import java.util.List;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;
import com.google.common.collect.ImmutableList;

import BaseTest.BaseTest;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class Util extends BaseTest {

	/*
	 * This Utility class contains various utility functions and methods.
	 */

	public void threadSleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void click(By byLocator) {

		scrollDownToElement(byLocator);

		WebElement element = getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(byLocator));

		element.click();

//		getUtil().threadSleep(1000);
		getUtil().waitForProgressWheelToDisappear();

	}

	public void sendkeys(By byLocator, String inputValue) {

		scrollDownToElement(byLocator);

		WebElement element = getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(byLocator));

		element.sendKeys(inputValue);

	}

	public String getTextFromWebElement(By byLocator) {
		String result = "";

		scrollDownToElement(byLocator);

		result = getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(byLocator)).getText();

		getExtentTest().log(Status.INFO, "Captured Text from WebElement: " + result);
		return result;
	}

	public void print(String stringToPrint) {
		System.out.println(stringToPrint);

	}

	public void printR(String stringToPrint) {
		System.err.println(stringToPrint);

	}

	public boolean isElementVisible(By byLocator) {
//		getUtil().threadSleep(4000);
		getUtil().waitForProgressWheelToDisappear();

		boolean elementPresence;

		try {
			if (getWebDriver().findElement(byLocator).isDisplayed()) {
				elementPresence = true;
			} else {
				elementPresence = false;
			}
		} catch (Exception e) {
			elementPresence = false;
		}

		return elementPresence;
	}

	public void logTest(boolean testStatus, String message) {

		if (testStatus == true) {
			logTestStatus(Status.PASS, message);
		} else if (testStatus == false) {
			logTestStatus(Status.FAIL, message);

		}

	}

	public void logTestStatus(Status status, String message) {
		getExtentTest().log(status, message);

	}

	///////////////////////////////////////////

	public String combineStringDifferentLine_ExReport(String string, String string2, String string3) {
		// TODO Auto-generated method stub
		String combinedString = "<br>" + string + "<br>" + string2 + "<br>" + string3 + "<br>";

		return combinedString;
	}

	/////////////////////////////////

	public void finalValidation(List<Boolean> testPoint, String testCaseName) {
		/* Final validation */
		threadSleep(500);
		if (verifyAll(testPoint) == true) {

			print(" ");
			print(" ");
			print("------------------------------------------------------");
			print(testCaseName + ": Passed");
			logTest(true, testCaseName + ": Passed");
			threadSleep(300);

			printTestStepResults(testPoint);

		} else {

			print(" ");
			print(" ");
			print("------------------------------------------------------");
			printR(testCaseName + ": Failed!");
			logTest(false, testCaseName + ": Failed!");
			threadSleep(300);

			printTestStepResults(testPoint);
		}

	}

	public boolean verifyAll(List<Boolean> inputTestSteps) {
		boolean b = true;

		for (int i = 0; i < inputTestSteps.size(); i++) {
			if (inputTestSteps.get(i) == false) {
				b = false;
				break;
			}
		}

		return b;
	}

	public void printTestStepResults(List<Boolean> testPoint) {
		String result = "";
		int validationStepNum = 0;

		for (int i = 0; i < testPoint.size(); i++) {
			if (testPoint.get(i) == true) {
				validationStepNum = i + 1;
				result = "Step " + validationStepNum + " Validation: " + "PASSED";
				print(result);
				threadSleep(200);

			} else {
				validationStepNum = i + 1;
				result = "Step " + validationStepNum + " Validation: " + "FAILED!!";
				printR(result);
				threadSleep(200);
			}
		}

		print("------------------------------------------------------");

	}

	public String findFailedTestStep(List<Boolean> inputTestSteps) {
		String failedStepNum = "";

		for (int i = 0; i < inputTestSteps.size(); i++) {
			if (inputTestSteps.get(i) == false) {
				int stepNum = i + 1;
				failedStepNum = "Failed Validation Step no." + stepNum;

				break;
			}
		}

		return failedStepNum;
	}

	public void goToCart() {

		getUtil().click(getPageObject().getHeaderCartButton());

	}

	public void swipe(Point start, Point end, Duration duration) {
		PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		Sequence swipe = new Sequence(input, 0);

		swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
		swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

		swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
		swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		getWebDriver().perform(ImmutableList.of(swipe));

	}

	public void scrollRightOfElement(By byLocator) {

		getUtil().waitForProgressWheelToDisappear();

		WebElement element = getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(byLocator));

		org.openqa.selenium.Dimension elementSize = element.getSize();
		Point elementLocation = element.getLocation();

		int elementHeight = elementSize.getHeight();
		int elementWidth = elementSize.getWidth();

		Point start = new Point(elementLocation.getX(), elementLocation.getY());
		Point end = new Point((int) (elementLocation.getX() - (elementLocation.getX() * 1.5)), elementLocation.getY());
//		Point end = new Point((int) (20), elementLocation.getY());

		swipe(start, end, Duration.ofMillis(300));
	}

	public void scrollDown() {
		org.openqa.selenium.Dimension size = getWebDriver().manage().window().getSize();

		Point midpoint = new Point((int) (size.width * 0.5), (int) (size.height * 0.5));

		int bottom = midpoint.y + (int) (midpoint.y * 0.75);
		int top = midpoint.y - (int) (midpoint.y * 0.75);

		Point start = new Point(midpoint.x, bottom);
		Point end = new Point(midpoint.x, top);

		swipe(start, end, Duration.ofMillis(300));

	}

	public void scrollDown(double factor) {
		org.openqa.selenium.Dimension size = getWebDriver().manage().window().getSize();

		Point midpoint = new Point((int) (size.width * 0.5), (int) (size.height * 0.5));

		int bottom = midpoint.y + (int) (midpoint.y * factor);
		int top = midpoint.y - (int) (midpoint.y * factor);

		Point start = new Point(midpoint.x, bottom);
		Point end = new Point(midpoint.x, top);

		swipe(start, end, Duration.ofMillis(300));

	}

	public void scrollDownToElement(By byLocator) {

		getUtil().waitForProgressWheelToDisappear();
		int limit = 12;

		for (int i = 0; i < limit; i++) {

			threadSleep(250);
//			getUtil().print("Waited for element and scrolling");
			try {
				if (getWebDriver().findElement(byLocator).isDisplayed()) {
					break;
				} else {
					scrollDown(0.25);

				}
			} catch (Exception e) {
				scrollDown(0.25);
			}

		}

	}

	public void waitForProgressWheelToDisappear() {

		getUtil().threadSleep(500);

		getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(getPageObject().getProgressWheel()));
	}

	public void addRandomProductAndGoToCart() {

		getExtentTest().info("Util: Adding a Random Product to cart and visiting cart afterwords");
		getUtil().print("Util: Adding a Random Product to cart and visiting cart afterwords");

		getUtil().menuNavigateTo("Electronics");

		getUtil().click(getPageObject().getPLPElectronicsSpecificProductMattressBedroom());

		getUtil().click(getPageObject().getPDPAddToCartCTA());

		getUtil().goToCart();

	}

	public void menuNavigateTo(String menuItemToVisit) {

		/* Conditions can be added/appended to navigate to more pages when required */

		if (menuItemToVisit.equalsIgnoreCase("Electronics")) {

			getUtil().click(getPageObject().getBottomNavigationCategory());

			getUtil().click(getPageObject().getBottomNavigationCategoryElectronics());
		}

	}

	public String capitalizeFirstCharacter(String str) {
		if (str == null || str.isEmpty()) {
			return str;
		}
		return Character.toUpperCase(str.charAt(0)) + str.substring(1);
	}

}