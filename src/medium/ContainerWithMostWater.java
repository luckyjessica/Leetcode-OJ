package medium;
/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 *  n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *  Note: You may not slant the container.
 * @author JieXu
 *
 */

// 当从两边向中间考虑时，乘水的面积是由（两端较小的高度）×（两个板之间的宽度）决定的。
// 假定初始的盛水面积为ans=0，lh为左边的高度，rh为右边的高度
// 如果lh < rh, 则向右运动，寻找第一个比当前lh大的左节点。同理，如果lh > rh，则向左运动，寻找第一个比当前rh大的右节点。
// 截止条件为坐标L >= R

// 这道题挺类似二分查找法的，这道题是先从两头开始算面积，面积的计算要由短板决定，并维护一个当前最大面积。
// 然后逐步替换小的短板来计算面积。每一步只替换短板的原因是，短板决定面积，而高板不影响，所以要想有所改变就改变那个有决定性的东西。。 

public class ContainerWithMostWater {
	public static int maxArea(int[] height){
		if(height.length<2) return 0;
		int left = 0;
		int right = height.length-1;
		int area = 0;
		while(left < right){
			int curr_area = 0;
			curr_area = Math.min(height[left], height[right])*(right - left);
			if(height[left]<height[right]) left++;
			else right--;
			area = Math.max(curr_area, area);
		}
		return area;
	}
	public static void main(String arg[]){
		int[]height={1,1};
		System.out.println(maxArea(height));
	}
}
