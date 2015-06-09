package easy;

import java.util.HashMap;

public class RomantoInteger {
	//Input is guaranteed to be within the range from 1 to 3999.
	public static int RtoI(String s){
		HashMap<Character, Integer> map = new HashMap<>();
	    map.put('I', 1);
	    map.put('V', 5);
	    map.put('X', 10);
	    map.put('L', 50);
	    map.put('C', 100);
	    map.put('D', 500);
	    map.put('M', 1000);
		if(s.equals("")) return 0;
		if(s.length()==1) return map.get(s.charAt(0));
		int digit,total = 0;
		int index = 0;
		// from left to right
		//如果当前比前一个大，说明这一段的值应该是当前这个值减去上一个值。比如IV = 5 – 1
		//否则，将当前值加入到结果中，然后开始下一段记录。比如VI = 5 + 1， II=1+1
		while(index < s.length() ){
			if(index+1==s.length()) return total+map.get(s.charAt(index));
			if(map.get(s.charAt(index)) < map.get(s.charAt(index+1))){
				digit = map.get(s.charAt(index+1)) - map.get(s.charAt(index));
				index += 2 ;
			}
			else{
				digit = map.get(s.charAt(index));
				index++;
			}
			total = digit + total;
		}
		return total; 
	}
	public static void main(String arg[]){
		System.out.println(RtoI("MCDLXXVI"));
	}
}
