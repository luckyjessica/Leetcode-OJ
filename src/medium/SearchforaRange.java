package medium;
/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4]
 * @author JieXu
 *
 */
public class SearchforaRange {
	public static int[] searchRange(int[] nums, int target) {
        if(nums.length==0 || target<nums[0]||target>nums[nums.length-1]) return new int[] {-1,-1};
        int low = 0;
        int high = nums.length - 1;
        while(low<=high){
        	System.out.println(low);
        	System.out.println(high);
        	int mid = (low+high)/2;
        	//找到左边的边界
        	if(target>nums[mid]) low = mid+1;
            else high = mid-1;
        	}
        //不存在
        if(target!=nums[low]) return new int[]{-1,-1};
        int start = low;
        System.out.println(start);

        //找到右边的边界
        high = nums.length - 1;
        while(low<=high){
        	int mid = (low+high)/2;
        	if(target<nums[mid]) high = mid-1;
        	else low = mid+1;
        }
    	System.out.println(high);	
        return new int[] {start,high};
	}
	
	public static void main(String[] args){
		int[] nums = {5, 7, 7, 7,7,8, 10};
		System.out.println(searchRange(nums,8));
	}
}
