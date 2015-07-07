package medium;

import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array 
 * such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 * @author JieXu
 *
 */

// TreeSet实现
//TreeSet数据结构（Java）使用红黑树实现，是平衡二叉树的一种。

//该数据结构支持如下操作：

//1. floor()方法返set中≤给定元素的最大元素；如果不存在这样的元素，则返回 null。

// 2. ceiling()方法返回set中≥给定元素的最小元素；如果不存在这样的元素，则返回 null。

public class _ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(k<1 || t<0) return false;
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		for(int i = 0 ; i<nums.length; i++){
			int tmp = nums[i];
			if(set.floor(tmp)!=null && tmp <= t+set.floor(tmp) || set.ceiling(tmp) != null && set.ceiling(tmp) <= t + tmp)
				return true;
			set.add(tmp);
			if(i >= k) set.remove(nums[i-k]);
		}
		return false;
	}
}
