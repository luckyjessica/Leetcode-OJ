package hard;
/**Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. 
 * Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".
**/

// 最短回文，所以从中点入手，中点右边的char不可能是新的palin的中心点
// 从中点开始，两边扩散，要是左边没到头已经发现两边不一样了，就不可能是这个中心点了，就返回继续下一个中点
// 扫一遍 左半部分要n/2, 扫一遍两边要n/2, O(n*n)
public class ShortestPalindrome {
	public static String shortestPalindrome(String s){
		if(s==null || s.length()==1) return s;
		String res = "";
		for( int i = (s.length()-1) / 2 ; i >=0 ; i--){
			System.out.println("i" + i);
			//偶数，i和i+1为中心,这样的palindrome是最短的
			res = shortest(s,i,i+1);
			if(res!=null) break;
			// 奇数， i为中心
			res = shortest(s,i,i);
			if(res!=null) break;
		}
		return res;	
	}
	public static String shortest(String s , int left, int right){
		while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
			left--;
			right++;
		}
		if(left>=0) return null;
		StringBuilder remain = new StringBuilder(s.substring(right));
		remain.reverse();
		remain.append(s);
		return remain.toString();
	}
	public static void main(String[] args){
		String s = "aba";
		System.out.println(shortestPalindrome(s));
	}
}
