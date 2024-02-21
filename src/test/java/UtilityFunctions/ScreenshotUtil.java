package UtilityFunctions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;

import BaseTest.BaseTest;

public class ScreenshotUtil extends BaseTest {

	public void screenshotSaveAndEmbed(String screenshotOf) {

		// Take a screenshot
		File screenshotFile = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);

		// Convert the screenshot to Base64
		byte[] screenshotBytes = null;
		try {
			screenshotBytes = Files.readAllBytes(screenshotFile.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String base64Screenshot = Base64.getEncoder().encodeToString(screenshotBytes);

		// Embed the screenshot in the report
		getExtentTest().info(screenshotOf,
				MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());

	}
}
