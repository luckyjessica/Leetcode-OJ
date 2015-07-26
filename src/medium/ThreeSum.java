package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
 * @author JieXu
 *
 */
public class ThreeSum {
	// 选定一个number， 用2sum夹逼剩下两个
	// T O(N^2), S O(1)
    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
    	// nlogn quick sort
    	Arrays.sort(nums);
    	// n * n/2 = n^2
    	for(int i = 0 ; i < nums.length-2 ; i = optimize(nums, i, 0)){
    		int target = 0-nums[i];
    		int low = i+1;
    		int high = nums.length - 1;
    		while(low<high){
    			if(nums[low] + nums[high] > target){
    				high = optimize(nums, high,1);
    			}
    			else if(nums[low] + nums[high] < target){
    				low = optimize(nums, low, 0);
    			}
    			//找到了
    			else{
    				List<Integer> oneset = Arrays.asList(nums[i],nums[low],nums[high]);
    				res.add(oneset);
    				//但是可能还会有重复，所以要继续找，找到low>high为止
    				low = optimize(nums, low, 0);
    				high = optimize(nums, high,1);
    			}
    		}
    	}
    	return res;    
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
		int[] nums= {0,0,2};
		System.out.println(threeSum(nums));
    }
}
