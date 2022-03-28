package practice;

public class CheckForInt {

	public static void main(String[] args) {
		String number="of 6";
		String splitNum = number.split(" ")[1];
		System.out.println(splitNum);
		int count=Integer.parseInt(splitNum);
		System.out.println(count);
	}

}
