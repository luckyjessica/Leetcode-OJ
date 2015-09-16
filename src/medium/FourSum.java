package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
 * @author JieXu
 *
 */
// 4sum,思路和3sum一样，就是多一个加数
// time o(n*n*n)
public class FourSum {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		//因为set要不重复，所以用hashset存放每个组合，
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        //存放所有符合条件的组合，返回的值
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // QUICK SORT O(nlogn)
        Arrays.sort(nums);
        for(int i=0; i < nums.length - 3 ; i=optimize(i,1,nums)){
        	for(int j = i+1 ; j < nums.length - 2 ; j=optimize(j,1,nums)){
        		int low = j+1;
        		int high = nums.length - 1;
        		int cur = target - nums[i]-nums[j];
        		while(low<high){
        			if(nums[low] + nums[high] > cur){
        				high = optimize(high,-1,nums);
        			}
        			else if (nums[low] + nums[high] < cur){
        				low = optimize(low,1,nums);
        			}
        			//找到了
        			else {
        				ArrayList<Integer> oneset = new ArrayList<Integer>();
        				oneset.add(nums[i]);
        				oneset.add(nums[j]);
        				oneset.add(nums[low]);
        				oneset.add(nums[high]);
        				res.add(oneset);
        				//不要忘记继续进位退位，因为答案要的是所有集合
        				low = optimize(low,1,nums);
        				high = optimize(high,-1,nums);
        				System.out.println(oneset);
        			}
        		}
        	}
        }
        return res;
    }

	public static int optimize(int index, int flag, int[] nums){
		if(flag==1){
			while(index < nums.length-1 && nums[index] == nums[index+1]){
				index++;
			}
		}else if(flag==-1){
			while(index>0 && nums[index] == nums[index-1]){
				index--;
			}
		}
		//！！！千万不要忘了还要继续移动一位啊！！！！
		return flag==1?index+1:index-1;
	}
	public static void main(String[] args){
		int[] nums = {-3,-2,-1,0,0,1,2,3};
		System.out.println(fourSum(nums,0));
	}
}
