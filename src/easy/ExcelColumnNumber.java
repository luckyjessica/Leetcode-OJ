package easy;

public class ExcelColumnNumber {
	public static int titletonumber(String s){
		//if s has char other than alphabet
		if(!s.matches("^[\\da-zA-Z]*$")) return 0;
		s = s.toUpperCase();
		int number = 0;
		for(int i=0 ; i<s.length() ; i++){
			number += (s.charAt(s.length()-i-1) - 'A' +1) * Math.pow(26,i);
		}
		return number;
	}
	public static void main(String arg[]){
		System.out.println(titletonumber("bAa"));
	}
}
