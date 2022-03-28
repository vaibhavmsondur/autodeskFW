package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultipleDataFromDataProvider {

	@Test(dataProvider = "getDataForContacts")
	public void createContact(String name,String mobileNo) {
		System.out.println(name);
		System.out.println(mobileNo);
	}
	
	@DataProvider
	public Object[][] getDataForContacts() {
		Object[][] objArray = new Object[5][2];
		
		objArray[0][0]="Vaibhav";
		objArray[0][1]="9738412660";
		
		objArray[1][0]="Vebs";
		objArray[1][1]="8660027018";
		
		objArray[2][0]="Vai";
		objArray[2][1]="8147088225";
		
		objArray[3][0]="Vaish";
		objArray[3][1]="7795529522";
		
		objArray[4][0]="Sonu";
		objArray[4][1]="9880991135";
		
		return objArray;
	}
}
