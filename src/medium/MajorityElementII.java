package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
 * The algorithm should run in linear time and in O(1) space.
 */
public class MajorityElementII {
	public static List<Integer> majorityElement(int[] nums) {
		ArrayList<Integer> list =  new ArrayList<Integer>();
		Arrays.sort(nums);
		int times = nums.length/3;

			for(int i= 0 ; i<nums.length ; i++){
			int count=1;
			while(nums[i]==nums[i+1]){
				count++;
				i++;
				if(i==nums.length) break;
			}
			if(count>times) list.add(nums[i-1]);			
	}
		return list;
	}
	public static void main(String[] args){
		int[] nums = {2,2};
		System.out.println(majorityElement(nums));
}
