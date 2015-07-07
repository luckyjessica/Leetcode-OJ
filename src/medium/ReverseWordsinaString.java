package medium;

import java.util.Stack;
/**
 * Given an input string, reverse the string word by word.
 * For example, 
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * @author JieXu
 *Clarification:
 *What constitutes a word?
 *A sequence of non-space characters constitutes a word.
 *Could the input string contain leading or trailing spaces?
 *Yes. However, your reversed string should not contain leading or trailing spaces.
 *How about multiple spaces between two words?
 *Reduce them to a single space in the reversed string.
 */
public class ReverseWordsinaString {
	// 用stack
	public static String reverseWords(String s){
		if(s.trim().length()==0) return "";
		StringBuilder res = new StringBuilder();
		Stack<Character> container = new Stack<Character>();
		
		for(int i = s.length() - 1 ; i >= 0 ; --i){
			if(s.charAt(i)!=' '){
				container.push(s.charAt(i));
			}
			else if(!container.isEmpty()){
				while(container.size()!=0){
					res.append(container.pop());
				}
				res.append(' ');
			}
		}
		if(!container.isEmpty()){
			while(container.size()!=0){
				res.append(container.pop());
			}	
		}
		return res.toString().trim();
	}
	// 直接split成字符串数组, 然后倒序打印
	public static String reverse(String s){
		if(s.trim().length()==0) return "";
		// !!!!!!!!! split one or more spaces
		String[] words = s.trim().split(" +");
		StringBuilder res = new StringBuilder();
		for(int i = words.length - 1 ; i >=0 ; --i){
			res.append(words[i]).append(" ");
		}
		return res.toString().trim();
	}
	public static void main(String arg[]){
		String a ="           the    sky is blue    ";
		System.out.println(reverse(a));
	}
}
