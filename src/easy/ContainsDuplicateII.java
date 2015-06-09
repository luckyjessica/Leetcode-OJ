package easy;

import java.util.HashMap;

/**
 * Given an array of integers and an integer k, 
 * return true if and only if there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the difference between i and j is at most k.
 * @author JieXu
 *
 */
public class ContainsDuplicateII {
	public static boolean containsDuplicate(int[] nums, int k) {
		HashMap<Integer,Integer> container = new HashMap<Integer,Integer>();
		for(int i = 0 ; i < nums.length ; i++){
			if(!container.containsKey(nums[i])) container.put(nums[i],i);
			else if((i - container.get(nums[i])) <= k) return true;
			// 更新key,为以后出现相同value做准备
			else container.replace(nums[i], i);
		}
		return false;
	}
	public static void main(String arg[]){
		int[] a ={1,2,3,4,6,2,8,2};
		System.out.println(containsDuplicate(a,2));
	}
}
