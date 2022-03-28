package com.crm.autodeskSelenium.genericUtility;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
/**
 * This class is used to get the Java Specific Generic Methods
 * @author VAIBHAV
 *
 */
public class JavaUtility {
	/**
	 * This method is used get the random number from 1 to maximum of 10000
	 * @return int
	 */
	public int getRandomNumber() {
		Random ran = new Random();
		int ranNum = ran.nextInt(10000);
		return ranNum;
	}
	/**
	 * This Method is used to get the System date in DD-MM-YYYY format 
	 * @return String
	 */
	public String getsystemDateDDMMYYYY() {
		Date d= new Date();
		String dates = d.toString();
		String year=dates.split(" ")[5];
		String date=dates.split(" ")[2];
		int month=d.getMonth()+1;
		String finalDate= date+"-"+month+"-"+year;
		return finalDate;
	}
	/**
	 * This Method is used to get the System date in YYYY-MM-DD format
	 * @return String
	 */
	public String getsystemDateYYYYMMDD() {
		LocalDateTime ldt= LocalDateTime.now();
		String day=ldt.toString();
		String mday = day.split("T")[0];
		return mday;
	}
	public String getsystemDateMonDDYYYY() {
			Date d= new Date();
			String dates = d.toString();
			String year=dates.split(" ")[5];
			String date=dates.split(" ")[2];
			String month= dates.split(" ")[1];
			String finalDate=month+" "+date+" "+year;
			return finalDate;
	}
	/**
	 * This method is to fetch the system date
	 * @return
	 */
	public String getSystemDate() {
		String tempFile = LocalDateTime.now().toString().replace(":", "-");
		return tempFile;
	}
}
