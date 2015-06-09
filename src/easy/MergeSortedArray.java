package easy;

/**
 * Given two sorted integer arrays nums1 and nums2
 * merge nums2 into nums1 as one sorted array.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * @author JieXu
 *
 */
public class MergeSortedArray {
	//不能新建数组，从后往前比！！！
	public static void mergesorted(int[] nums1, int m, int[] nums2, int n){
		while(m>0 && n>0){
			if(nums1[m-1] > nums2[n-1]){
				nums1[m + n - 1] = nums1[m-1];
				m--;
			}
			else{
				nums1[m + n - 1] = nums2[n-1];
				n--;
			}
		}
		//if m = 0 and n != 0, that means elements in nums1[] has all passed
		while(n>0){
			nums1[n-1] = nums2[n-1];
			n--;
		}
	}
	public static void main(String arg[]){
		int[] a = {0};
		int[] b = {1};
		mergesorted(a, 0, b, 1);
	}
}
