package medium;
/**Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. 
 * You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 * @author JieXu
 *
 */

//DP,只要能赚钱就做交易
public class BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices){
		if(prices.length==0) return 0;
		int maxProfit = 0;
		for(int i = 1 ; i < prices.length ; i++ ){
			maxProfit = Math.max(maxProfit,  maxProfit+prices[i]-prices[i-1]);
		}
		return maxProfit;
	}
}
