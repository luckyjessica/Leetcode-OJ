package easy;

public class FactorialTrailingZeroes {
	// note that int can only represent 2147483648 MAX!!!
	public static int zeroes(int n){
		// count 5 in factorial, that would be the number of 0
        if(n<5) return 0;
        int count = 0;
		while(n>0){
			n = n/5;
			count+=n;
		}
		return count;
	}
	public static void main(String arg[]){
		System.out.println(zeroes(45));
	}
}
