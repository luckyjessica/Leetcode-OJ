package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 * @author JieXu
 *
 */
public class PascalTriangle {
	public static List<List<Integer>> pasacal(int numRows){
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> onerow = new ArrayList<Integer>();

		if(numRows < 1) return triangle;		
		for(int i = 1 ; i <= numRows ; i++){
			for(int j = i - 1 ; j > 1 ; j--){
				onerow.set(j-1, onerow.get(j-2) + onerow.get(j-1));
			}
			// 记住java传递的是引用！！！！
			// 所以注意不要每次加的都是onerow引用的arraylist
			// 要新建一个tmp list！！
			onerow.add(1);
			triangle.add(onerow);
		}
		return triangle;
	}
	public static void main(String arg[]){
		System.out.println(pasacal(4));
		}
}
