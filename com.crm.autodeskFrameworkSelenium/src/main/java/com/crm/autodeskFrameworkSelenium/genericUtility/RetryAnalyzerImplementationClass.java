package com.crm.autodeskFrameworkSelenium.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class is for Retry the Failed Test Scripts using IRetryAnalyzer interface
 * @author VAIBHAV
 *
 */
public class RetryAnalyzerImplementationClass implements IRetryAnalyzer{
	int count=0;
	int retryCount=5;
	public boolean retry(ITestResult result) {	
		
		if (count<retryCount) {
			count++;
			
			return true;
		}
		return false;
	}
	
}
