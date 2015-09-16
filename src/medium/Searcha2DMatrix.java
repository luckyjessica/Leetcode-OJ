package medium;
/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
 * @author JieXu
 *
 */
//time o(log(c)*r)
public class Searcha2DMatrix {
	public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||target<matrix[0][0]||target>matrix[matrix.length-1][matrix[0].length-1]) return false;
        for(int i = 0 ; i<matrix.length;i++){
        	System.out.println(i);
            int low = 0;
            //num of columns
            int high = matrix[0].length-1;
            while(low<=high){
            	int mid = (low+high)/2;
            	//直接跳到下一行搜索 i++
            	if(target>matrix[i][high])break;
            	//比该行最小的要小，说明不在matrix里，false;
            	if(target<matrix[i][low]) return false;
            	//binary search
            	if(target==matrix[i][mid]) return true;
            	else if(target<matrix[i][mid]) high = mid-1;
            	else low = mid+1;
            }
        }
        return false;
	}
	//优化的方法，分别做两次binary search,一次找到所在行，一次搜索该行
	// time o(logc+logr)
	public static boolean searchMatrixOptimize(int[][]matrix,int target){
        if(matrix.length==0||target<matrix[0][0]||target>matrix[matrix.length-1][matrix[0].length-1]) return false;
        int low = 0;
        int high = matrix.length - 1;
        while(low<=high){
        	int mid = (low+high)/2;
        	if(target>matrix[mid][0]) low = mid+1;
        	else if(target<matrix[mid][0]) high = mid-1;
        	else return true;
        }
        //target可能所在的row
        int row = high;
        low = 0;
        high = matrix[0].length-1;
        while(low<=high){
        	int mid = (low+high)/2;
        	if(target==matrix[row][mid]) return true;
        	else if(target>matrix[row][mid]) low = mid+1;
        	else high = mid-1;
        }
        return false;
	}
	public static void main(String[] args){
		int[][] nums = {
		                {1,   3,  5,  7},
		                {10, 11, 16, 20},
		                {23, 30, 34, 50}
		                };
		System.out.println(searchMatrixOptimize(nums,5));
	}
}
