package medium;

public class GasStation {
	/**
	 * 仔细想一下，其实和以前求最大连续子数组和的题很像。 
	 * 在任何一个节点，其实我们只关心油的损耗，定义： 
	 * diff[i] = gas[i] – cost[i] 0<=i <n 
	 * 那么这题包含两个问题： 
	 * 1. 能否在环上绕一圈？ 
	 * 2. 如果能，这个起点在哪里？ 
	 * 第一个问题，很简单，我对diff数组做个加和就好了，leftGas = ∑diff[i]， 如果最后leftGas是正值，那么肯定存在这么一个起始点。如果是负值，那说明，油的损耗大于油的供给，不可能有解。得到第一个问题的答案只需要O(n)。
	 * 
	 * 对于第二个问题，起点在哪里？ 
	 * 假设，我们从环上取一个区间[i, j], j>i， 然后对于这个区间的diff加和，定义 
	 * sum[i,j] = ∑diff[k] where i<=k<j 
	 * 如果sum[i,j]小于0，那么这个起点肯定不为i，跟第一个问题的原理一样。
	 * 举个例子，假设i是[0,n]的解，那么我们知道 任意sum[k,i-1] (0<=k<i-1) 肯定是小于0的，否则解就应该是k。
	 * 同理，sum[i,n]一定是大于0的，否则，解就不应该是i，而是i和n之间的某个点。
	 * 所以第二题的答案，其实就是在0到n之间，找到第一个连续子序列（这个子序列的结尾必然是n）大于0的。
	 * @param gas
	 * @param cost
	 * @return
	 */
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int current = 0;
		int index = 0;
		int total = 0;
		for(int i= 0 ; i<gas.length ; i++){
			//到下一个时当前的油量
			current += gas[i] - cost[i];
			total += gas[i] - cost[i];
		    if(current < 0){
		        // 从下一位开始重新开始 油箱清零
		    	index = i + 1;
		    	current = 0;
		    }
		}
		if (total <0) return -1;
		else return index;
	}
}
