package easy;
/**
 * Given two binary strings
 * return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * @author JieXu
 *
 */
public class _AddBinary {
	//这个方法会溢出，所以是不对的！！！
	public static String addBinary(String a, String b) {
		if(a.equals("0") || b.equals("0")) return a.equals("0")? b:a;
		int m=0,n=0;
		for(int i = a.length() - 1 ; i >=0  ; i--){
			if(a.charAt(i)=='1') m += (int)Math.pow(2, a.length() -1 - i);
		}
		for(int i = b.length() - 1 ; i >=0  ; i--){
			if(b.charAt(i)=='1') n += Math.pow(2, b.length() -1- i);
		}
		return Integer.toBinaryString(m+n);
	}
	
	public static String addBinaryright(String a, String b) {
		int m = a.length();
	    int n = b.length();
	    int carry = 0;
	    String res = "";
	    // the final length of the result depends on the bigger length between a and b, 
	    // (also the value of carry, if carry = 1, add "1" at the head of result, otherwise)
	    int maxLen = Math.max(m, n);
	    for (int i = 0; i < maxLen; i++) {
	        // start from last char of a and b
	        // notice that left side is int and right side is char
	        int p=0,q=0;
	        if(i<m)
	            p = a.charAt(m-1-i) - '0';
	        else
	            p = 0;
	        
	        if(i<n)
	            q = b.charAt(n-1-i)-'0';
	        else
	            q = 0;
	            
	        int tmp = p + q + carry;
	        carry = tmp / 2;
	        res += tmp % 2;
	    }
	    return (carry == 0) ? res : "1" + res;
	}
	public static void main(String arg[]){
		System.out.println(addBinary("1010","1011"));
	}
}
