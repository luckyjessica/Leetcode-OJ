package easy;

import java.util.Arrays;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.
 * @author JieXu
 *
 */
public class ValidAnagram {
	//time o(nlogn) space o(n)
	public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        char[] a = s.toCharArray();
        //nlogn quick sort
        Arrays.sort(a);
        char[] b = t.toCharArray();
        Arrays.sort(b);
        for(int i = 0; i<a.length ; i++){
        	if(a[i]!=b[i]) return false;
        }
        return true;
    }
	
	//用 ASCII码
	public static boolean isAnagram2(String s, String t) {
		if(s.length()!=t.length()) return false;
		int[] char_count = new int[256];
		char[] a = s.toCharArray();
		for(char i : a){
			char_count[i] = char_count[i]+1;
		}
		for(int i=0;i<t.length();i++){
			//如果不是变位词，因为两个string长度相等
			//所以必然有一个char在s2里出现的比s2里多
			if(char_count[t.charAt(i)]<1){
				return false;
			}
			else {
				char_count[t.charAt(i)]--;
			}
		}
		return true;
	}
	public static void main(String[] args){
		System.out.println(isAnagram2("asdd","dgaa"));
	}
}
