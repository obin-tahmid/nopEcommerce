package UtilityFunctions;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import BaseTest.BaseTest;

public class RetryAnalyzer extends BaseTest implements IRetryAnalyzer, IAnnotationTransformer {
	private int MAX_RETRY_COUNT = 2;
	private int retryCount = 0;

	@Override
	public boolean retry(ITestResult result) {

		if (retryCount < MAX_RETRY_COUNT) {

			retryCount++;

			return true;

		}

		return false;

	}

	public int getRetryCount() {
		return retryCount;
	}

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}
}
