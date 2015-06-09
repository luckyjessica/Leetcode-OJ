package easy;

import java.util.HashSet;

public class HappyNumber {
	public static boolean isHappy(int n){
		if(n<=0) return false;
		HashSet<Integer> box = new HashSet<Integer>();
		while(!box.contains(n)){
			box.add(n);
			int sum = 0;
			while(n>0){
				sum += (n%10)*(n%10);
				n = n/10;
			}
			n = sum;
			if(sum==1) return true;
		}
		return false;
	}
	public static void main(String arg[]){
		System.out.println(isHappy(7));
	}
}
