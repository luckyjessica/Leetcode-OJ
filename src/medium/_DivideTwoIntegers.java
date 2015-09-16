package medium;
/**
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 * @author JieXu
 *
 */
//用减法慢慢减 time o(n) 不太好，可以优化
public class _DivideTwoIntegers {
	public static int divide(int dividend, int divisor) {
        if(dividend==0||divisor==0) return 0;
        long res = 0;
        boolean isNeg = ((dividend > 0 && divisor <0) || (dividend <0 && divisor>0))? true:false;
        long a = dividend;
        long b = divisor;
        if(a==Integer.MIN_VALUE && b==-1) return Integer.MAX_VALUE;
        a = Math.abs(a);
        b = Math.abs(b);
        while(a-b >= 0){
        	a = a-b;
        	res++;
        }
        //Min_int / -1 这样的情况结果正数会溢出
        return isNeg?(int)(-res):(int)res;
	}
	
	//优化 bianry search o(logn)
	//任何一个整数可以表示成以2的幂为底的一组基的线性组合，即num=a_0*2^0+a_1*2^1+a_2*2^2+…+a_n*2^n
	public static int optimize(int dividend, int divisor){
		if(dividend==0||divisor==0) return 0;
		long res = 0;
        boolean isNeg = ((dividend > 0 && divisor <0) || (dividend <0 && divisor>0))? true:false;
        long a = dividend;
        long b = divisor;
        a = Math.abs(a);
        b = Math.abs(b);

        if(a<b) return 0;
        
        long sum = 0;
        long pow = 0;

        while(a>=b){
        	pow = 1;
        	sum = b;
        	while(sum + sum <= a){
        		sum += sum;
        		pow += pow;
        	}
        	a -= sum;
        	res += pow;
        }
        res = isNeg?-res:res;
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return Integer.MAX_VALUE;
		return (int)res;
	}
	public static void main(String[] args){
		System.out.println(optimize(Integer.MIN_VALUE, 1));
	}
}
