package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
 * @author JieXu
 *
 */
/**
考虑到只有4种字母，ACGT，固定10位字符，所以排列组合数是一定的，仅有4^10 = 1048576种可能.
因此，可以让10位字符序列做一个Hash。
A = 00
C = 01
G = 10
T = 11
将他们拼接起来，变成一个数value。

如： AAACCC = 00 00 00 01 01 01 （二进制） = 21 （十进制）
然后遍历整个序列，每10个字符生成一个value。
因为只需要判断10个字符的值，每个字符占2位，所以我们只需要20位的bit，通过掩码0xFFFFF来过滤掉10位之前的字符所对应的位。
当某value出现过一次后，就将对应的序列加入到结果中。
**/
public class RepeatedDNASequences {
	public static List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<String>();
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		map.put('A', 00);
		map.put('C', 01);
		map.put('G', 10);
		map.put('T', 11);
		
		HashMap<Integer,Integer> sumMap = new HashMap<Integer,Integer>();
		int sum = 0;
		for(int i = 0 ; i < s.length(); i++){
			//二进制加法，<<向左位移两位，加上下一位字符
			sum = ((sum << 2) + map.get(s.charAt(i))) & 0xFFFFF;
			//如果小于9的话就说明一轮都没pass完，直接下一个for就行
			if(i<9) continue;
			Integer count = sumMap.get(sum);
			//这里为什么是==1呢，因为如果是>1的话，说明之前就重复了，所以之前就被加进了list，不用重复加入了
			if(count!=null && count == 1){
				res.add(s.substring(i-9,i+1));
			}
			sumMap.put(sum, count != null ? count+1 : 1);
		}
		return res;
	}
	public static void main(String[] args){
		String s = "AAAAAAAAAAAA";
		System.out.println(findRepeatedDnaSequences(s));
	}
}
