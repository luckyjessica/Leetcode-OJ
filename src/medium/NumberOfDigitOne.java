package medium;
/**
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 * @author JieXu
 *
 */

public class NumberOfDigitOne {
	//用递归来做
	public static int countone(int n){
		if(n<=0) return 0;
		int count = 0;
		int factor = 1;
		int k = n;
		while(k>=10){
			k = k/10;
			factor = factor * 10;
		}
		if(k>1) count = factor;
		else count = n % factor + 1;
		return count + countone(n % factor) + k * countone(factor - 1);
	}
	//非递归
	 public static int iterative(int n) {  
	        int count = 0;  
	        int factor = 1;  
	        int lowerdigit = 0;  
	        int currdigit = 0;  
	        int higherdigit = 0;  
	        while (n / factor != 0){  
	            lowerdigit = n % factor;  
	            currdigit = (n / factor) % 10;  
	            higherdigit = n / (factor * 10);  
	            switch (currdigit){  
	                case 0:  
	                    count += higherdigit * factor;  
	                    break;  
	                case 1:  
	                    count += higherdigit * factor + lowerdigit + 1;  
	                    break;  
	                default:  
	                    count += (higherdigit + 1) * factor;  
	                    break;  
	            }  
	            factor = factor * 10;  
	        }  
	        return count;  
	    }  
	 
	public static void main(String[] args){
		System.out.println(iterative(13));
	}
}
