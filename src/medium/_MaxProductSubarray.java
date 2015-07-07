package medium;
/**
 * Find the contiguous subarray within an array (containing at least one number) 
 * which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 * @author JieXu
 */
// 题目分析：求一个数组，连续子数组的最大乘积。
// 其实子数组乘积最大值的可能性为：累乘的最大值碰到了一个正数；
// 或者，累乘的最小值（负数），碰到了一个负数。所以每次要保存累乘的最大（正数）和最小值（负数）。
// 同时还有一个选择起点的逻辑，如果之前的最大和最小值同当前元素相乘之后，
// 没有当前元素大（或小）那么当前元素就可作为新的起点。
// 例如，前一个元素为0的情况，{1,0,9,2}，到9的时候9应该作为一个最大值，也就是新的起点，
// {1,0,-9,-2}也是同样道理，-9比当前最小值还小，所以更新为当前最小值。
// 这种方法只需要遍历一次数组即可，算法时间复杂度为O(n)。
public class _MaxProductSubarray {
	// return the max product
	public static int maxProduct(int[] nums) {
		if(nums.length==1) return nums[0];
		int max_curr = nums[0];
		int min_curr = nums[0];
		int max_global = nums[0];
		
		for(int i = 1 ; i<nums.length ; ++i){
			int max_potential = max_curr * nums[i];
			int min_potential = min_curr * nums[i];
			                    // check之前最小的是不是乘了一个负数变成最大的了
			max_curr = Math.max(Math.max(max_potential, min_potential),nums[i]);
			min_curr = Math.min(Math.min(min_potential, max_potential),nums[i]);
			
			max_global = Math.max(max_curr, max_global);
		}
		return max_global;
	}
	
	// max_curr=2,min_curr=2,global=2,
	// i=1  max_potential=8,min_potential=8,
	// max_curr = 8, min_curr = 4; global = 8
	// i=2 max_potential=-24,min_potential=-12,
	// max_curr = -3, min_curr = -24, global = 8
	// i=3 max_potential=-30,min_potential=-240, 
	// max_curr = 10, min_curr = -240,global = 10	
	
	public static void main(String arg[]){
		int[] nums = {2,4,-3,10};
		System.out.println(maxProduct(nums));
	}
}
