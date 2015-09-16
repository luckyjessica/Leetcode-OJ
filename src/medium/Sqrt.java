package medium;
/**
 * Implement int sqrt(int x).

Compute and return the square root of x.
 * @author JieXu
 *
 */
//二分法 binary search. time o(logn)
public class Sqrt {
	public static int mySqrt(int x) {
		if(x<0) return -1;
		if(x==0) return 0;
		//一个数的平方根一定比它的一半+1要小
		long high = x/2 + 1;
		long low = 0;
		//注意这里要用<=
		while(low<=high){
			long mid = (low+high)/2;
			System.out.println("low"+low);
			System.out.println("high"+high);
			System.out.println("mid"+mid);
			if(mid*mid<x){
				low = mid+1;
			}else if(mid*mid>x){
				high = mid-1;
			}else return (int)mid;
		}
		return (int)high;
    }
	public static void main(String[] args){
		System.out.println(mySqrt(8));
	}
}
