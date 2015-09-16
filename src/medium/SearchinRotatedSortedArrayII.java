package medium;
/**
 * Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
 * 0 1 1 2 3 3 4 5 -  2 3 3 0 0 0 1
 * @author JieXu
 *
 */
//binary search
//time 最坏o(n) 一般logn
public class SearchinRotatedSortedArrayII {
	public static boolean search(int[] nums, int target) {
        if(nums.length==0) return false;
        int low = 0;
        int high = nums.length-1;
        while(low<high){
        	int mid = (low+high)/2;
        	if(nums[mid]==target) return true;
        	//前半部分有序
        	if(nums[mid]>nums[high]){
        		//在后半部分
        		if(target>nums[mid] || target<nums[low]){
        			low = mid+1;
        		//在前半部分
        		}else high = mid-1;
        	//后半部分有序
        	}else if (nums[mid]<nums[high]){
        		//在前半部分
        		if(target>nums[high] || target < nums[mid]){
        			high = mid-1;
        		//在后半部分
        		}else low = mid+1;
        	//nums[mid]==nums[high]
        	//注意这里，可能是mid=low=high这种情况，无法缩减一半，让指向边缘值的指针分别往前移动，忽略掉这个相同点，再用之前的方法判断即可。
        	//我这时候就把边缘high缩小1
            //因为我用high比较，所以减小high,如果用low比较，就low++
            //因为这步，所以最坏的情况下，time o不再是logn,而是n
        	}else high--;
        }
        return nums[low]==target?true:false;
    }
	
	public static void main(String[]args){
		int[] nums = {0,0,0,0,3,0};
		System.out.println(search(nums,3));
	}
}
