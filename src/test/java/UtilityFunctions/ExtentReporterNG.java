package UtilityFunctions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import BaseTest.BaseTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExtentReporterNG extends BaseTest {
	static ExtentReports extent;

	public static ExtentReports extentReportGenerator(String device) {

		String path = System.getProperty("user.dir") + "\\report\\" + device + "- Automation"
				+ getCurrentFormattedDate() + ".html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Ecommerce Test Scenarios");
		reporter.config().setDocumentTitle(device + " Ecommerce Test Scenarios");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Test Name: ", "Cart & order");
		extent.setSystemInfo("Device: ", device);
		extent.setSystemInfo("Tester: ", "Obin Tahmid");

		return extent;

	}

	public static String getCurrentFormattedDate() {
		// Define the desired date format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");

		// Get the current date
		LocalDate currentDate = LocalDate.now();

		// Format the current date using the defined format
		String formattedDate = currentDate.format(formatter);

		return formattedDate;
	}

}
