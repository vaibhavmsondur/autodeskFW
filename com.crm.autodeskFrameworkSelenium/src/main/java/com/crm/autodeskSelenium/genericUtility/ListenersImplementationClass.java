package com.crm.autodeskSelenium.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
/**
 * This class is used for the implementation of ITestListener Interface
 * @author VAIBHAV
 *
 */
public class ListenersImplementationClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "--------> Execution Started");
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "---------> Execution Passed");
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "-------> Execution Failed");
		System.out.println(result.getThrowable());
		
		try {
			String path = new WebDriverUtility().takeScreenshot(BaseClass.sDriver, methodName);
			System.out.println(path);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "------> Execution Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		System.out.println("Execution Started");
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("Execution Finished");
		ITestNGMethod[] sample = context.getAllTestMethods();
		for (ITestNGMethod iTestNGMethod : sample) {
			System.out.println(iTestNGMethod.getDescription());
		}
	}
}
