package easy;

public class ReverseBit {
	public static int reverse(int n){
		// assume input n is unsigned value
		int result = 0;
		for(int i=0 ; i<32; i++){
			//get the right most bit of n
			int rightmost = n & 1;
			// mirror it
			int settoopposite = rightmost << (31-i);
			//add up to current result
			result = result | settoopposite;
			// right move one bit
			n >>>= 1;
		}
		return result;
	}
	public static void main(String arg[]){
		System.out.println(reverse(43261596));
	}
}
