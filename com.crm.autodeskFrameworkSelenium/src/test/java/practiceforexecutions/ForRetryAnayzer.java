package practiceforexecutions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ForRetryAnayzer {
	@Test(retryAnalyzer = com.crm.autodeskSelenium.genericUtility.RetryAnalyzerImplementationClass.class)
	public void retryAsasdfhcgjvg() {
		System.out.println("Retry");
		Assert.fail();
	}
}
