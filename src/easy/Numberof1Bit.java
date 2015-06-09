package easy;

public class Numberof1Bit {
	//n is a unsigned value
	// java has signed value
	public static int count(int n){
		int count=0;
		while(n>0){
			if((n & 1)==1) count++;
			n>>>=1;
		}
		return count;
	}
	public static void main(String arg[]){
		System.out.println(count(6));
	}
}
