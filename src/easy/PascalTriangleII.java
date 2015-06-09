package easy;

import java.util.ArrayList;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3, Return [1,3,3,1].
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 * @author JieXu
 *
 */
public class PascalTriangleII {
	public static ArrayList<Integer> pascal(int k){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(k<0) return null;
		result.add(1); 
		if(k==0) return result;
		// i th rows, start from 1, total k+1 rows
		//一次for完成时， i 时，有 i+1 个元素
		for(int i = 1; i <= k ; i++){
			// 需要跟踪的是j-1的数据，所以j-1不能动，所以要反过来 j--
			// 从最后一个元素开始遍历 最后一个元素的index为i-1
			for(int j = i - 1 ; j > 0 ; j--){
				result.set(j, result.get(j-1) + result.get(j));
			}
			result.add(1); 
		}
		return result;
	}
	public static void main(String arg[]){
		System.out.println(pascal(4));
	}
}
