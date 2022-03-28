package practiceforexecutions;

import org.testng.annotations.Test;

public class Test2 {
	@Test(groups="ft")
	public void sample6() {
		System.out.println("sample6");
	}
	
	@Test(groups="it")
	public void sample7() {
		System.out.println("sample7");
	}
	
	@Test(groups="rt")
	public void sample8() {
		System.out.println("sample8");
	}
	
	@Test(groups="st")
	public void sample9() {
		System.out.println("sample9");
	}
	
	@Test(groups="smokeTest")
	public void sample10() {
		System.out.println("sample10");
	}
}
