package practice;

import org.testng.annotations.Test;

public class PriorityPractice {

	@Test(priority=2)
	public void sample() {
		System.out.println("sample");
	}
	
	@Test(priority=1)
	public void kailash() {
		System.out.println("kailash");
	}
	
	@Test(priority=-2)
	public void virot() {
		System.out.println("virot");
	}
}
