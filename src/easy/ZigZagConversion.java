package easy;

import java.util.HashMap;

public class ZigZagConversion {
	public static String convert(String s, int numRows) {
		if (numRows==1) return s;
		HashMap<Integer,StringBuilder> container = new HashMap<Integer,StringBuilder>();
		for(int i = 1 ; i<=numRows ; i++){
			container.put(i, new StringBuilder());
		}
		//notice the use of direction!!!!
		int direction = 1;
		for(int i = 0, pointer = 1 ; i < s.length() ; i++){
			container.get(pointer).append(s.charAt(i));
			if(pointer == numRows) direction = -1;
			if(pointer == 1) direction = 1;
			pointer += direction;
			}
		StringBuilder all = new StringBuilder();
		for(int i = 1 ; i<=container.size() ; i++){
			all.append(container.get(i).toString());
		}
		return all.toString();
	}
	public static void main(String arg[]){
		System.out.println(convert("ABCD", 3));
	}
}
