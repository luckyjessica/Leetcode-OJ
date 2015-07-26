package medium;

import java.util.HashMap;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 
Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.
Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 * @author JieXu
 *
 */
// two pointers, time O(n), space O(1)
public class TwoSumII_Inputarrayissorted {
	public static int[] twosumsorted(int[] nums, int target){
		int[] res = new int[2];
		int start = 0;
		int end = nums.length -1 ;
		while(end>start){
			int tmp = nums[end] + nums[start];
			if(tmp>target) end = end - 1;
			else if(tmp<target) start = start + 1;
			else{
				res[0] = start + 1;
				res[1] = end + 1;
				break;
			}
		}
		return res;
	}
	//hash table, O(n), O(n)
	public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length ; i++){
            if(map.containsKey(nums[i])){
                res[0] = map.get(nums[i])+1;
                res[1] = i+1;
                break;
            }
            else map.put(target - nums[i] , i);
        }
        return res;
    }
	public static void main(String[] args){
		int[] nums = {1,3,5,7,9,15};
		System.out.println(twoSum(nums,14)[0]);
		System.out.println(twoSum(nums,14)[1]);
	}
}
