package practice;

import org.testng.annotations.Test;

public class DependsOnMethods {

	@Test
	public void login() throws Throwable {
		System.out.println("login");
		//throw new Exception();
	}
	
	@Test(dependsOnMethods = "login")
	public void createContact() throws Exception {
		System.out.println("createContact");
		throw new Exception();
	}
	
	@Test(dependsOnMethods = {"createContact"})
	public void logout() {
		System.out.println("logout");
	}
}
