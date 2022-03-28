package practiceforexecutions;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions {
	@Test
	public void hardAssert() {
		String name1= "Vaibhav";
		String name2= "Vaibhav";
		
		List<String> al1 = new ArrayList<String>();
		al1.add("Radha");
		al1.add("Poojashree");
		al1.add("Roshan");
		
		List<String> al2 = new ArrayList<String>();
		al2.add("Radha");
		al2.add("Poojashree");
		al2.add("Roshan");
		
		int a=10;
		int b=10;
		
		int[] arr1= {10,20};
		int[] arr2= {10,20};
		
		Assert.assertEquals(name1, name2);
		Assert.assertEquals(a, b);
		Assert.assertEquals(al1, al2);
		Assert.assertEquals(arr1, arr2);
	}
	
	@Test
	public void softAssert() {
		String name1= "Vaibhav";
		String name2="Vaibhav";
		
		int a=10;
		int b=10;
		
		int[] arr1= {10,20};
		int[] arr2= {10,20};
		SoftAssert sa= new SoftAssert();
		
		sa.assertEquals(name1, name2);
		sa.assertEquals(a, b);
		sa.assertEquals(arr1, arr2);
		sa.assertAll();
	}
}
