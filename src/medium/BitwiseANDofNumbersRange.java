package medium;
/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647
 *  return the bitwise AND of all numbers in this range, inclusive.
 *  For example, given the range [5, 7], you should return 4.
 *  
 *  0101
 *  0110
 *  0111
 *  ----
 *  0100 = 4
 * @author JieXu
 *
 */
//The little trick is to return the left common parts of two numbers. 
//When not equal, move right for 1 bit, util equal, return the common parts.

public class BitwiseANDofNumbersRange {
	public static int bitwise(int m,int n){
		int moves = 0;  
		// keep moving the two integers with one digit rightwards every time
		// when find the two intgers same, roll back the moves
        while(m != n) {  
            m >>= 1;  
            n >>= 1;  
            moves++;  
        }             
        return m << moves;  
	}
}
