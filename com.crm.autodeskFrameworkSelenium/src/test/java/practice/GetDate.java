package practice;

import java.util.Date;

public class GetDate {

	public static void main(String[] args) {
//		LocalDateTime ldt= LocalDateTime.now();
//		String day=ldt.toString();
//		System.out.println(day);
//		String mday = day.split("T")[0];
//		System.out.println(mday);
		Date d= new Date();
		String dates = d.toString();
		String year=dates.split(" ")[5];
		String date=dates.split(" ")[2];
		String month= dates.split(" ")[1];
		System.out.println( month);
		String finalDate=month+" "+date+" "+year;
		//int month=d.getMonth()+1;
//		if (month<=9) {
//			String monthDigit = "0"+month;
//			finalDate= year+"-"+monthDigit+"-"+date;
//		}else {
//			month= 0+ month;
//			finalDate= year+"-"+month+"-"+date;
//		}
		
		System.out.println(finalDate);
		
		
	}

}
