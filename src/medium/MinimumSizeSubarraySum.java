package medium;

import java.util.Arrays;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 * @author JieXu
 *
 */
//注意是子数组！！不能改变顺序的！！！
public class MinimumSizeSubarraySum {
	//滑动窗口方法 o(n)
	//定义两个指针left和right，
	//然后我们让right向右移，直到子数组和大于等于给定值或者right达到数组末尾，此时我们更新最短距离
	//并且将left像右移一位，然后再sum中减去移去的值
	//然后重复上面的步骤，直到right到达末尾，且left到达临界位置，即要么到达边界，要么再往右移动，和就会小于给定值
	public static int minSubArrayLen(int s, int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int low = 0,high = 0;
        int cur_sum = 0;
        int res = Integer.MAX_VALUE;
        while(high<nums.length && low<=high){
        	cur_sum += nums[high];
        	while(cur_sum>=s){
        		res = Math.min(high-low+1, res);
        		//！这一步是滑动窗口的核心！
        		cur_sum -= nums[low]; 
        		low++;
        	}
        	high++;
        }
        return res==Integer.MAX_VALUE? 0:res;
    }
	//还有一个o(nlogn),这个解法要用到二分查找法
	//我们建立一个比原数组长一位的sums数组，其中sums[i]表示nums数组中[0, i - 1]的和，
	//然后我们对于sums中每一个值sums[i]，用二分查找法找到子数组的右边界位置，使该子数组之和大于sums[i] + s
	//然后我们更新最短长度的距离即可
	public static int minSubArrayLen2(int s,int[]nums){
		int len = nums.length, res = len + 1;
		int[] sums = new int[len+1];
		for (int i = 1; i < len + 1; ++i){
			sums[i] = sums[i - 1] + nums[i - 1];
		}
		for (int i = 0; i < len + 1; ++i) {
			int right = searchRight(i + 1, len, sums[i] + s, sums);
			if (right == len + 1) break;
			if (res > right - i) res = right - i;
		}
		return res == len + 1 ? 0 : res;
	}
    public static int searchRight(int left, int right, int key, int sums[]) {
    	while (left <= right) {
    		int mid = (left + right) / 2;
    		if (sums[mid] >= key) right = mid - 1;
    		else left = mid + 1;
		}
		return left;
    }
	public static void main(String[]args){
		int[] nums = {2,3,1,2,4,3};
		System.out.println(minSubArrayLen(7,nums));
	}
}
