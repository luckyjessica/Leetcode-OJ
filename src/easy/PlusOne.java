package easy;

public class PlusOne {
	// non-negative integer!!
	public static int[] plus(int[] digits){
		for(int i = digits.length - 1 ; i>=0 ; i--){		
			digits[i] += 1;
			if(digits[i]==10) digits[i] = 0;
			else return digits;
		}
		int[] answer = new int[digits.length + 1];
		answer[0] = 1;
		for(int i=1 ; i<answer.length ; i++){
			answer[i]=digits[i-1];
		}
		return answer;   
	}
	public static void main(String arg[]){
		int[] a = {1,2,3};
		System.out.println(plus(a)[1]);
	}
}
