package easy;

public class LengthofLastWord {
	//倒过来遍历
	public static int length(String s){
		if(s.trim().equals("")) return 0;
		int count = 0;
		for(int i = s.length() -1 ; i>=0 ; i--){
			if(s.charAt(i)!=' ') count++;
			if(s.charAt(i)==' ' && count != 0) return count;
		}
		return count;
	}
	public static void main(String arg[]){
		String s = "a";
		System.out.println(length(s));
	}
}
