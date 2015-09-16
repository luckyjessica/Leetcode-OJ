package medium;

import java.util.HashMap;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
 * @author JieXu
 *
 */
public class _FractiontoRecurringDecimal {
	//注意陷阱：负数
	//注意陷阱：取绝对值时会溢出
	public static String fractionToDecimal(int numerator, int denominator) {
		if(denominator==0) return "error";
		if(numerator == 0) return "0";
		//先转成long,以免INT_MIN取模或除以-1时溢出
		long a = numerator;
		long b = denominator;
		if(a % b==0) return Long.toString(a/b);
		//记录正负号
		boolean flag=true;
		if(a * b<0) flag = false;
		//取模
		a = Math.abs(a);
		b = Math.abs(b);

		//记录最后返回的值
		StringBuilder res = new StringBuilder();
		res.append(a/b);
		long remainer = a % b;
		//记录小数部分, key是小数位，value是出现的位置
		HashMap<Long,Integer> map = new HashMap<Long,Integer>();
		res.append(".");
		while(remainer!=0){
			if(map.containsKey(remainer)){
				int index = map.get(remainer);
				//stringbuilder的insert方法，第一个arg是插入的位置在arg前面
				res.insert(index,'(').append(")");
				break;
			}
			else{
				res.append(remainer*10 / b);
				map.put(remainer, res.length()-1);
			}
			//不要忘记更新余数！
			remainer = remainer * 10 % b;
		}
		return flag?res.toString():"-"+res.toString();
	}
	public static void main(String[] args){
		System.out.println(fractionToDecimal(-2147483648,-1));
	}
}
