package easy;
/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Given input array nums = [1,1,2]
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 * @author JieXu
 *
 */
public class RemoveDuplicatesfromSortedArray {
	// SORTED!!!!
	public static int removeDuplicates(int[] nums){
		if(nums.length <= 1) return nums.length;
		int count = 1;
		int i = 0;
		for (int j = 1 ; j < nums.length ; j++){
			//后某一位值比i位置的值大
			if(nums[j] > nums[i]){
				//把j位的值赋到数组前面，目前有几个重复的就赋值到后面
				nums[count] = nums[j];
				count++;
				//接着可以之前从这一位座位基数开始找，因为是有序的数组
				i = j;
			}
		}

		for(int x = 0 ; x < nums.length ; x++){
			System.out.print(nums[x]+"--");
		}
		System.out.println();
		
		return count;
	}
	public static void main(String arg[]){
		int[] a = {1,1,1,1};
		System.out.println(removeDuplicates(a));
	}
}
