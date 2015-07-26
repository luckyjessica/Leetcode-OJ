package medium;
/**
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * @author JieXu
 *
 */
public class LongestPalindromicSubstring {
	/**
	 *eg: abcdcbdef, we should return bcdcb
	 *eg: abcddcbef, we should return bcddcb
	 */
//思路： 以每个char为中心，向两边扫描，还要考虑到偶数奇数的情
//比如aacc, 假设以a为中心，两边各加1，不是palindrome, 但是假设以(a,c)为中心，就是的
	    public static String longestPalindrome(String s) {
	    	if(s==null || s.length()==0) return "";
	    	String res = "";
	    	for(int i = 0 ; i < s.length(); i++){
	    		//当单独char为中心
	    		String str = longest(s, i, i);
	    		//以两个char中间位中心
	    		String str2 = longest(s,i,i+1);
	    		if(str.length()>str2.length()){
	    			res = str.length()>res.length()? str : res;
	    		}
	    		else res = str2.length() > res.length()? str2:res;
	    	}
	    	return res;
	    }
	    
	    // 
	    public static String longest(String s, int left, int right){
	    	while(right<s.length() && left>=0 && s.charAt(left)==s.charAt(right)){
	    		//不断向外扩散
	    		left--;
	    		right++;
	    	}
	    	//别忘了把left--和right++加回来和减回去1一个index，因为while break时已经加或减过1的
	    	// substring(s,a,b)从index a开始，到b-1结束
	    	return s.substring(left + 1, right);
	    }
	    
	    public static void main(String[] args){
	    	String s = "abcddcbef";
	    	System.out.println(longestPalindrome(s));
	    }
}
