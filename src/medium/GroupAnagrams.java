package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.
 * @author JieXu
 *
 */
public class GroupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		// key是string的按字母排序，value是anagram的集合
		HashMap<String, ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
		if(strs.length==0 || strs==null) return res;

		//把每个str放进map
		for(int i = 0 ; i<strs.length ; i++){
			char[] tmp = strs[i].toCharArray();
			Arrays.sort(tmp);
			String cur = new String(tmp);
			//如果已经存在key,就加在value的list后面
			if(map.containsKey(cur)){
				map.get(cur).add(strs[i]);
			}else{
		    //如果没有，新建一个entry
				map.put(cur, new ArrayList<String>(Arrays.asList(strs[i])));
			}
		}
		System.out.println(map);
		//提取每一个key,把key对应的value (arraylist的node)按字母排序
		for(String a : map.keySet()){
			Collections.sort(map.get(a));
			res.add(new ArrayList<String>(map.get(a)));
		}
		return res;		
    }
	public static void main(String[] args){
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(strs));
	}
}
