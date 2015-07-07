package medium;
/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * !!! You may assume no duplicate exists in the array.
 * @author JieXu
 *
 */
public class MinimuminRotatedSortedArray {
	// O(n) time complexity
	public static int findMin(int[] nums) {
		for(int i = 1 ; i< nums.length ; ++i){
			if(nums[i] < nums[i-1]) return nums[i];
		}
		return nums[0];
	}
	// !!!! O(logn) , binary search
	// 通过左边界和中间的大小关系来得到左边或者右边有序的信息，
	// 比较mid和high的值，不断缩小一半范围
	// 这样子每次可以截掉一半元素，所以最后复杂度等价于一个二分查找，是O(logn)，
	// 空间上只有四个变量维护二分和结果，所以是O(1)。
	public static int findBinary(int[]nums){
		int low = 0;
		int high = nums.length-1;
		int mid = (low+high)/2;
		while(low<high){
			//在后半部分
			if(nums[mid] > nums[high]){
				low = mid+1;
			}
			//在后半部分
			else {
				high = mid;
			}
			mid = (low+high)/2;
		}
		return nums[low];
	}
	public static void main(String arg[]){
		int[] b ={1,2};
		System.out.println(findBinary(b));
	}
}
