package practiceforexecutions;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodeskFrameworkSelenium.genericUtility.BaseClass;

@Listeners(com.crm.autodeskFrameworkSelenium.genericUtility.ListenersImplementationClass.class)
public class SampleTest extends BaseClass{
	@Test
	public void create() {
		System.out.println("Passed");
	}
	
	@Test
	public void fail() {
		Assert.fail();
	}
	
	@Test
	public void skip() {
		new SkipException("Skipped");
	}
}
