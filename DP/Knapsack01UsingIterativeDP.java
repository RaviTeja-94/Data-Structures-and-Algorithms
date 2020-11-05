import java.util.Arrays;

public class Knapsack01UsingIterativeDP {

	
		// using iterative dp or tabulation method or bottom up method (O(n*capacity))
	public static int getMaxProfit(int[] wt, int[] profits, int capacity, int n) {
			// create 2-d dp array with capacity of n+1 and W+1
			
		int[][] dp = new int[n+1][capacity+1];
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=capacity;j++) {
				// if no items or no capacity left
				if(i==0 || j==0) {
					dp[i][j] = 0;
				}
				else {
					// skip if weight of current item is greater than the current capacity by excluding the current item
					if(wt[i-1]>j) {
						dp[i][j] = dp[i-1][j];
					}
					else {
						// checking if the current item can be included or not to attain max profit
						dp[i][j] = Math.max(dp[i-1][j], profits[i-1]+dp[i-1][j-wt[i-1]] );
					}
				}
			}
		}
			
		return dp[n][capacity];
	}
		
	public static void main(String[] args) {
		int[] wt= {10,20,90};
		int[] profits = {60,100,120};
		int capacity = 100;
		
		int maxProfit = getMaxProfit(wt, profits, capacity, 3 );
		System.out.println(maxProfit);
		
	}
}
