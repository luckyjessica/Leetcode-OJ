package medium;
/**
 * Implement pow(x, n).
 * @author JieXu
 *
 */
//XXXX！直接做，会溢出 o(n),所以不行
public class Pow {
	public static double myPow(double x, int n) {
		double res = 1;
		long a = n;
		int flag;
		if(a==0) return 1;
		else if(a==1) return x;
		else if(a>0){
			flag = 1;
		}else{
			flag = -1;
			n = n >> 1;
		}
		while(n>0){
			res = res*x;
			n--;
		}
		return flag==1?res:1/res;
    }
	
	//所以要用二分法，2/n * 2/n = n
	public static double pow(double x,int n){
		if(n==0) return 1;
		if(n==1) return x;
		double res = 1;
		long a = n;
		if(a<0)	a = -a;
		while(a>0){
			//如果是奇数
			if((a&1)==1){
				res = res*x;
			}
			a = a/2;
			x = x*x;
		}
		if(n<0) return 1/res;
		else return res;
	}
	public static void main(String[] args){
		System.out.println(pow(2, 3));
	}
}

