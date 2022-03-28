package practiceforexecutions;

import org.testng.annotations.Test;

public class Test1 {
	
	@Test(groups="ft")
	public void sample1() {
		System.out.println("sample1");
	}
	
	@Test(groups="it")
	public void sample2() {
		System.out.println("sample2");
	}
	
	@Test(groups="rt")
	public void sample3() {
		System.out.println("sample3");
	}
	
	@Test(groups="st")
	public void sample4() {
		System.out.println("sample4");
	}
	
	@Test(groups="smokeTest")
	public void sample5() {
		System.out.println("sample5");
	}
}
