package easy;

public class StringtoInteger_atoi {
	public static int Myatoi(String str)  throws NumberFormatException {
		// if s is null, return null;
		int total = 0;
		int flag = 1;
		int index =0;
		// clean the white space
		str = str.trim();
		if(str.equals("")) return 0;
		// check negative or positive
		if(str.charAt(0)=='-'){
			index++;
			flag = -1;
		}
		else if(str.charAt(0)=='+'){
			index++;
			flag = 1;
		}
		for( ; index < str.length() ;index++){
			if(str.charAt(index)<'0' || str.charAt(index)>'9') return total * flag;
			// if next operation will overflow?
			// 正数溢出 total > max/10 或者 total == max/10并且当前的char > 7
			// !!!!!!!
			if((Integer.MAX_VALUE/10 < total) || (Integer.MAX_VALUE/10 == total && 7 < str.charAt(index) - '0'))
                return flag == 1?Integer.MAX_VALUE:Integer.MIN_VALUE;

			total = (str.charAt(index) - '0') + total*10;


		}
		return total * flag;
	}
	
	public static void main(String arg[]){
		System.out.println(Myatoi("-2147483648"));
	}

}
