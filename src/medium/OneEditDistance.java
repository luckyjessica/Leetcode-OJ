package medium;
/**Given two strings S and T, determine if they are both one edit distance apart.
 * 
 * @author JieXu
 *
 */
public class OneEditDistance {
	public static boolean isOneEdit(String a, String b){
		if(Math.abs(a.length()-b.length()) > 1) return false;
		if(a.length() > b.length()) return helper(b,a);
		return helper(a,b);
	}
	public static boolean helper(String a, String b){
		//两种情况
		//1. 长度相等，那么只可以有一个字符不一样
		//2. 长度不想等，发现不一样字符之后，短的string的指针减小一，接下来的字符应该都一样
		//flag表示是否已经发现了一个不一样的字符
		boolean flag=false;
		for(int i = 0, j = 0 ; i< a.length() ; i++,j++){
			if(a.charAt(i)!=b.charAt(j)){
				if(flag==true) return false;
				flag = true;
				if(a.length()<b.length()) i--;
			}
		}
		//长度差1，差在结尾
		if(a.length()<b.length() && flag==false) return true;
		//长度差1，差在中间
		//and 长度相等，差在中间
		return flag;
	}
}
