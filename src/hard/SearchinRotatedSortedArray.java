package hard;
/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 * @author JieXu
 *
 */
//binary search ，time o(logn)
//1.判断那半部分是有序的
//2.判断target在有序的那一边还是无序的那一边
//3.缩小一半范围
public class SearchinRotatedSortedArray {
	public static int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        int low = 0;
        int high = nums.length - 1;
        while(low<high){
        	int mid = (low+high)/2;
        	if(target==nums[mid]) return mid;
    		//right half is sorted
        	if(nums[mid]<nums[high]){
        		//target大于后半部分最大的，或者小于中间的数，说明它在前半部分
        		if(target>nums[high] || target<nums[mid]){
        			high = mid-1;
        		}else low = mid+1;
        	//left half is sorted
        	}else if(nums[mid]>nums[high]){
        		//target在后半部分
        		if(target>nums[mid] || target<nums[low]){
        			low = mid+1;
        		}else high = mid-1;
        	}//这里nums[mid]==nums[high]的情况不存在，因为low!=high,且没有重复
        }
        return nums[low]==target?low:-1;
    }
	public static void main(String[] args){
		int[] nums = {4,5,6,7,8,0,1,2};
		System.out.println(search(nums,5));
	}
}

