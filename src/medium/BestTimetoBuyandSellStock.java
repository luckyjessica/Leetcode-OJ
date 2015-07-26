package medium;
/**Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
**/
//DP,只能交易一次，所以只要找最小值和最大值就可以了，
//但是最小值要在最大值前面，所以改成维护一个当前最大利润，和一个当前最小值
public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices){
		if(prices.length==0) return 0;
		int maxProfit = 0;
		int minPrice = prices[0];
		for(int i = 1 ; i < prices.length ; i++){
			maxProfit = Math.max(maxProfit,prices[i]-minPrice);
			minPrice = Math.min(minPrice,prices[i]);
		}
		return maxProfit;
	}
}
