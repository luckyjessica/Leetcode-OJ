package medium;
/**
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.


 * @author JieXu
 *
 */
//!!!!!!注意，一定存在peak ele!!!!!
public class FindPeakElement {
	/**低级解法 o(n)**/
	public static int findPeakElement(int[] nums){
		if(nums.length==1) return 0;
		if(nums.length==0) return -1;
		for(int i = 0;i<nums.length;i++){
			if(i==0){
				if(nums[i]>nums[i+1]) return i;
			}else if(i==nums.length-1){
				if(nums[i]>nums[i-1]) return i;
			}else{
				if(nums[i]>nums[i-1] && nums[i]>nums[i+1]) return i;
			}
		}
		return -1;
	}
	
	/** 另一种o(n)
    从第一个元素开始，若其大于相邻的后续元素，则第一个元素就是一个局部最大值，返回即可
	若其小于相邻的后续元素，则第二个元素大于第一个元素
	如此，一一遍历数组，第一次出现，第i个元素若大于其相邻后续元素，则该元素就是一个局部最大值，返回
	**/
	public static int findPeakElement2(int[] nums) {
		for(int i=1;i<nums.length;i++){
			//注意这个语句，很精妙
			if(nums[i]<nums[i-1]) return i-1;
		}
		return nums.length-1;
	}
	
	/**binary search解法 o(logn)
	如果中间元素大于其相邻后续元素，则中间元素左侧(包含该中间元素）必包含一个局部最大值
	如果中间元素小于其相邻后续元素，则中间元素右侧必包含一个局部最大值。

                      4

       3          3     5

    2    2    2

 1          1

    **/
	public static int findPeakElement3(int[]nums){
		int low = 0;
		int high = nums.length-1;
		while(low<high){
			int mid = (low+high)/2;
			//小于后面一个
			if(nums[mid]<nums[mid+1]) low = mid+1;
			//大于后面一个（题目说了相邻不重复）
			else high = mid;
		}
		return high;
	}
	
	public static void main(String[] args){
		int[] nums = {1, 2, 3, 2};
		System.out.println(findPeakElement3(nums));
	}
}
