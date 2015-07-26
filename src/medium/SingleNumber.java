package medium;
/**Given an array of integers, every element appears twice except for one. Find that single one.
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * @author JieXu
 *
 */
//用bit manipulation,按位异或
public class SingleNumber {
	public static int singlenumber(int[] nums){
		int total = 0;
		for(int i = 0 ; i<nums.length ; i++){
			total = total ^ nums[i];
		}
		return total;
	}
	public static void main(String[] args){
		int[] nums = {1,3,2,1,3,5,6,6,2};
		System.out.println(singlenumber(nums));
	}
}
