
public class Knapsack01UsingRecursion {

	// using recursion(2^n)
	public static int getMaxProfit(int[] wt, int[] profits, int capacity, int n) {
		//check if all items are processed or if the capacity is already filled
		if(capacity==0 || n==0) {
			return 0;
		}
		
		//skip the item if item exceeds capacity available
		if(wt[n-1]> capacity) {
			return getMaxProfit(wt, profits, capacity, n-1);
		}
		//item weight doesn't exceed the current capacity but check if we want to include it or exclude it to attain max profit
		return Math.max(getMaxProfit(wt, profits, capacity, n-1), profits[n-1]+getMaxProfit(wt, profits, capacity-wt[n-1], n-1));
		
		
	}
	
	public static void main(String[] args) {
		int[] wt= {10,20,30};
		int[] profits = {60,100,120};
		int capacity = 50;
		
		int maxProfit = getMaxProfit(wt, profits, capacity, 3 );
		
		System.out.println(maxProfit);
	}
}
