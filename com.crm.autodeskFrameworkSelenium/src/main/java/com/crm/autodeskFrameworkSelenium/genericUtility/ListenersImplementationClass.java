package com.crm.autodeskFrameworkSelenium.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class is used for the implementation of ITestListener Interface
 * @author VAIBHAV
 *
 */
public class ListenersImplementationClass implements ITestListener{

	ExtentReports html;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		//Step 3
		test = html.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		//Step 4
		test.log(Status.PASS, result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		//Step 6
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
		//Screenshot
		WebDriverUtility wObj= new WebDriverUtility();
		String path=null;
		try {
			path=wObj.takeScreenshot(BaseClass.sDriver, result.getMethod().getMethodName());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {
		//Step 5
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onStart(ITestContext context) {
		//Step 1: extent report
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./extenteport"+new JavaUtility().getSystemDate()+".html");
		htmlReport.config().setReportName("Smoke Report");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setDocumentTitle("Vtiger Report");
		
		//Step 2: Configuration
		html = new ExtentReports();
		html.attachReporter(htmlReport);
		html.setSystemInfo("OS", "Windows 10");
		html.setSystemInfo("Environment", "Testing Environment");
		html.setSystemInfo("Url", "http://localhost:8888");
		html.setSystemInfo("Reporter Name", "Vaibhav");
	}

	public void onFinish(ITestContext context) {
		html.flush();
	}
}
