package easy;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * @author JieXu
 *
 */
/**
 * 一个个检查给的characters，如果是左括号都入栈；
 * 如果是右括号，检查栈如果为空，证明不能匹配，
 * 如果栈不空，弹出top，与当前扫描的括号检查是否匹配
 * @author JieXu
 *
 */
public class VaildParenthese {
	public static boolean isVaild(String s){
		if(s.length()%2 != 0) return false;
		Stack<Character> left = new Stack<Character>();
		for(int i = 0 ; i < s.length() ; i++ ){
			if(s.charAt(i)=='{'|| s.charAt(i)=='(' || s.charAt(i)=='[')
				left.push(s.charAt(i));
			else{
				if(left.isEmpty()) return false;
				if(s.charAt(i) == '}'){
					if(left.pop()=='{') continue;
					else return false;
				}
				if(s.charAt(i) == ')'){
					if(left.pop()=='(') continue;
					else return false;
				}
				if(s.charAt(i) == ']'){
					if(left.pop()=='[') continue;
					else return false;
				}
			}
		}
		// if the stack is unempty after the iteration, means not vaild
		if(!left.isEmpty()) return false;
		return true;
	}
	public static void main(String arg[]){
		System.out.println(isVaild("(("));
	}
}
