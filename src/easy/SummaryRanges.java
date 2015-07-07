package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * @author JieXu
 *
 */
// O(n)time, O(1)space
//思路：两个指针，一个在目前范围的起点，一个向后找，发现当前值不是前一个值加1的时候，addlist元素
public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
    	List<String> res = new ArrayList<String>();
    	int start=0,curr=0;
    	while(curr<nums.length){
    		if(curr == nums.length-1 || nums[curr]+1 != nums[curr+1]){
    			if(curr==start) res.add(String.valueOf(nums[start])); 				
    			else res.add(nums[start] + "->" + nums[curr]);
    			start = curr+1;
			}
			curr++; 		
    	}
    	return res;
    }
    public static void main(String arg[]){
    	int[]nums = {1,2,5};
    	System.out.println(summaryRanges(nums));
    }
}
