package medium;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * @author JieXu
 *
 */
//和three sum一样，就是要动态维护一个delta
// T O(n^2) , S O(1)
public class ThreeSumClosest {
	public static int threeSumClosest(int[]nums,int target){
		int delta = Integer.MAX_VALUE;
		// quick sort(nlogn)
		Arrays.sort(nums);
		// n * n/2 = n^2
		for(int i = 0 ; i < nums.length -1 ; i = optimize(nums,i,0)){
			int low = i+1;
			int high = nums.length-1;
			int x = target - nums[i];

			while(low<high){
				if(Math.abs((nums[low] + nums[high] - x)) < Math.abs(delta)){
					delta = nums[low] + nums[high] - x;
				}
				if(nums[low] + nums[high]> x){
    				high = optimize(nums, high,1);
				}
				else if(nums[low] + nums[high] < x){
    				low = optimize(nums, low, 0);
    			}
				else return target;

			}
		}
		return delta + target;
	}
	 private static int optimize(int[] nums, int n,int flag) {
	        if(flag==0){
	            while (n < nums.length - 1 && nums[n] == nums[++n]) {}
	        }
	        else if(flag==1){
	            while (n > 0 && nums[n] == nums[--n]) {}

	        }
	     return n;
	 }
	 public static void main(String[] args){
			int[] nums= {0,1,1,1};
			System.out.println(threeSumClosest(nums,100));
	    }
}
