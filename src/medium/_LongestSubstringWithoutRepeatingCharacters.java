package medium;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters. For example,
 * the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * @author JieXu
 *
 */
public class _LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
    	if(s.length() == 0 || s.length() == 1) return s.length();
    	int res = 0;
    	HashMap<Character,Integer> map = new HashMap<Character,Integer>();
    	for(int walker = 0,runner = 0 ; runner < s.length();runner++){
    		if(map.containsKey(s.charAt(runner)) && map.get(s.charAt(runner)) >= walker){
    			walker = map.get(s.charAt(runner)) + 1;
    		}
    		else res = Math.max(res, runner - walker+1);
    		map.put(s.charAt(runner),runner);
    	}
    	return res;
    }
    public static void main(String[] args){
    	String s = "aaacbba";
    	System.out.println(lengthOfLongestSubstring(s));
    }
}
