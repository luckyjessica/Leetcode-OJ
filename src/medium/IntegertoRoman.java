package medium;

/**
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * @author JieXu
 *
 */
// !!!!左减的数字有限制，仅限于I、X、C。比如45不可以写成VL，只能是XLV
// 但是，左減時不可跨越一個位數。
/**(1, 'I');
(5, 'V');
(10, 'X');
(50, 'L');
(100, 'C');
(500, 'D');
(1000, 'M');
*/
public class IntegertoRoman {
	public static String intToRoman(int num){
		String str = "";
		// 就一下13种排列组合
		String [] map = { "M", "CM", "D", "CD", "C", "XC" ,"L", "XL", "X" ,"IX", "V", "IV","I" };
		// 分别对应这些数值
		int[] value ={1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		int i = 0;
		while(num!=0){
			// 为什么这里用while不用if呢？
			// 是为了防止有相同字母出现两次的情况，比如CCC
			while(num >= value[i]){
				str += map[i];
				num -= value[i];
			}
			i++;
		}
		return str;
	}
	public static void main(String arg[]){
		System.out.println(intToRoman(300));
	}
}
