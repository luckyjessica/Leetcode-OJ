package medium;
/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
           3 - 1 ;
 * @author JieXu
 *
 */
//binary search time o(logn)
public class SearchInsertPosition {
	public static int searchInsert(int[] nums, int target) {
      if(nums.length==0||target<nums[0])return 0;  
      if(target>nums[nums.length-1])return nums.length;
      int low = 0;
      int high = nums.length - 1;
      while(low<high){
    	  int mid = (low+high)/2;
    	  if(target>nums[mid]) low = mid+1;
    	  else high = mid;
      }
      //low==high的时候只有一个元素，不管target在不在array里，都是插在那个位置
      return low;
    }
	public static void main(String[]args){
		int[] nums={1,3,5,6};
		System.out.println(searchInsert(nums,7));
	}
}
