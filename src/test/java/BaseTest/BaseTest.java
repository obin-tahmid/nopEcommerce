package BaseTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import UtilityFunctions.PageObject;
import UtilityFunctions.Util;
import UtilityFunctions.ExtentReporterNG;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

	/*
	 * BaseTest: responsible for instantiation of driver, reporting, wait, utility,
	 * page Object and other core variables
	 */

//	public static AppiumDriver driver;
	public static AndroidDriver driver;
	public static Util util;
	public static WebDriverWait wait;
	public static PageObject object;
	public static ExtentReports extent;
	public static ArrayList<Boolean> testValidations = new ArrayList<Boolean>();
	public static ExtentTest test;

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Inside Before Suite!");

		initializeExtentReport();

	}

	private void initializeTestValidations() {
		// TODO Auto-generated method stub

	}

	protected void setExtentTest(ExtentTest test) {
		this.test = test;
	}

	public ExtentTest getExtentTest() {
		return this.test;
	}

	public void setTestvalidations(ArrayList<Boolean> testPoint) {
		this.testValidations = testPoint;

	}

	public ArrayList<Boolean> getTestValidations() {
		return this.testValidations;

	}

	private void initializeExtentReport() {
		this.extent = ExtentReporterNG.extentReportGenerator("Android phone");

	}

	private void initializeDriver() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// Set your device capabilities
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("udid", "emulator-5554");
		capabilities.setCapability("automationName", "UiAutomator2");
//        capabilities.setCapability("appPackage", "com.nopstation.nopcommerce.nopstationcart");
//        capabilities.setCapability("appActivity", "com.bs.ecommerce.main.MainActivity"); 
//		capabilities.setCapability("app", "C:\\Users\\obint\\eclipse-workspace\\nopcart\\nopstationCart_4.40 1.apk");
		capabilities.setCapability("app",
				System.getProperty("user.dir") + File.separator + "nopstationCart_4.40 1.apk");

//        capabilities.setCapability("appium:appWaitActivity", "com.bs.ecommerce.main.MainActivity");

		// Set the Appium server URL
		URL serverUrl = null;
		try {
//            serverUrl = new URL("http://127.0.0.1:4723/wd/hub");
			serverUrl = new URL("http://127.0.0.1:4723");
//			serverUrl = new URL("http://192.168.1.105:4723");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		// Initialize the AndroidDriver instance
//		driver = new AndroidDriver(serverUrl, capabilities);
		setWebDriver(new AndroidDriver(serverUrl, capabilities));

	}

	@BeforeMethod
	public void beforeMethod() {
		initializeDriver();

		initializeWebDriverWait();

		initializePageObject();

		initializeUtilityObject();

		initializeTestValidations();

		System.out.println("getUtil() = " + getUtil());
	}

	@AfterMethod
	public void afterMethod() {

		extent.flush();
		getWebDriver().quit();
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	public void setWebDriver(AndroidDriver driver) {
		this.driver = driver;

	}

	public AndroidDriver getWebDriver() {
		return (AndroidDriver) this.driver;

	}

	private void initializePageObject() {
		setPageObject(new PageObject());

	}

	public void setPageObject(PageObject pageObject) {
		this.object = pageObject;

	}

	public PageObject getPageObject() {
		return this.object;

	}

	public void initializeWebDriverWait() {
		setWebDriverWait(new WebDriverWait(driver, Duration.ofSeconds(40)));

	}

	public void setWebDriverWait(WebDriverWait webDriverWait) {
		this.wait = webDriverWait;

	}

	public WebDriverWait getWebDriverWait() {
		return this.wait;

	}

	public void initializeUtilityObject() {
		setUtil(new Util());

	}

	public void setUtil(Util util) {
		this.util = util;

	}

	public Util getUtil() {
		return this.util;

	}

	@AfterSuite
	public void afterSuite() {
		// Quit the driver
		if (driver != null) {
			driver.quit();
		}
	}
}
