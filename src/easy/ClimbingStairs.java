package easy;
/**
 * You are climbing a stair case. 
 * It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top?
 * @author JieXu
 *
 */
public class ClimbingStairs {
    // for each step, choose from 1 step or 2 step + its previous step
	public static int climbing(int n){
		if(n==0||n==1||n==2) return n;
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3 ; i < n+1 ; i++){
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
}
