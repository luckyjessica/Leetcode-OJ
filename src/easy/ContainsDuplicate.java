package easy;

import java.util.HashSet;

public class ContainsDuplicate {
	public static boolean isContain(int[] nums){
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0 ;i<nums.length ; i++){
			if(set.contains(nums[i])) return true;
			set.add(nums[i]);
		}
		return false;
	}
	public static void main(String arg[]){
		int[] a ={0};
		System.out.println(isContain(a));
	}
}
