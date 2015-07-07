package easy;
/**Given an integer, write a function to determine if it is a power of two.
 * 
 */
// keep mod n to see if the mod equals 0, if not, return false
public class PowerofTwo {
	public boolean isPowerofTwo(int n){
		if(n<1) return false;
		while(n>0){
			if(n==1) return true;
			if(n%2 != 0) return false;
			n = n/2;
		}
		return true;
	}
}
