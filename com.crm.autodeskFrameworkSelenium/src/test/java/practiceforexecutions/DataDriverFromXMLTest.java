package practiceforexecutions;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class DataDriverFromXMLTest {
	@Test
	public void getDataFromXml(XmlTest xml) {
		String browser = xml.getParameter("browser");
		String url = xml.getParameter("url");
		String username = xml.getParameter("username");
		String password = xml.getParameter("password");
		
		System.out.println("browser "+browser);
		System.out.println("url "+url);
		System.out.println("username "+username);
		System.out.println("password "+password);
		
	}
}
