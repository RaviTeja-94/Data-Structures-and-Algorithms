import java.util.Arrays;

public class Knapsack01UsingMemoization {
	
		// using recursion with memoization(O(N*W))
		public static int getMaxProfit(int[] wt, int[] profits, int capacity, int n, int[][] dp) {
			//check if all items are processed or if the capacity is already filled
			int result;
			
			if(capacity==0 || n==0) {
				return 0;
			}
			
			//check if this sup problem is already solved and return it directly instead of computing it again
			if(dp[n-1][capacity-1] != -1) {
				return dp[n-1][capacity-1];
			}
			
			//skip the item if item exceeds capacity available
			if(wt[n-1]> capacity) {
				result =  getMaxProfit(wt, profits, capacity, n-1, dp);
			}
			//item weight doesn't exceed the current capacity but check if we want to include it or exclude it to attain max profit
			result =  Math.max(getMaxProfit(wt, profits, capacity, n-1, dp), profits[n-1]+getMaxProfit(wt, profits, capacity-wt[n-1], n-1, dp));
			
			dp[n-1][capacity-1] = result;
			
			return dp[n-1][capacity-1];
			
		}
		
		public static int getMaxProfit(int[] wt, int[] profits, int capacity, int n) {
			
			// create 2-d dp array with capacity of n+1 and W+1
			
			int[][] dp = new int[n+1][capacity+1];
			
			// intialize with -1 in the beginning
			
			for(int[] row:dp) {
				Arrays.fill(row, -1);
			}
			
			return getMaxProfit(wt, profits, capacity, n, dp);
		}
		
		public static void main(String[] args) {
			int[] wt= {10,20,30};
			int[] profits = {60,100,120};
			int capacity = 50;
				
			int maxProfit = getMaxProfit(wt, profits, capacity, 3 );
			
			System.out.println(maxProfit);
		}
		
}
