package easy;
/**Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * @author JieXu
 *
 */
public class ValidParlindrome {
	//using two pointers, one from head, one from tail
	public static boolean isPalindrome(String s) {		
		s = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
		for(int i =0;i<s.length()/2;i++){
			if(s.charAt(i)!=s.charAt(s.length()-i-1))return false;
		}
		return true;
	}
	public static void main(String arg[]){
		System.out.println(isPalindrome(".,1221"));
	}
}
