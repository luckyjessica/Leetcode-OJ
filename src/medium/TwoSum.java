package medium;
/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 */
import java.util.HashMap;
// time o(n)
public class TwoSum {
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
		int[] nums= {2,2,7,4,5};
		System.out.println(twoSum(nums,4)[0]);
		System.out.println(twoSum(nums,4)[1]);

	}
}
