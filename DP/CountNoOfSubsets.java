
public class CountNoOfSubsets {

	public static int countNoOfSubsetsWithGivenSum(int[] arr, int sum) {
		
		int noOfItems = arr.length;
		int[][] dp = new int[noOfItems+1][sum+1];
		
		//if sum is 0 then we can an empty set to represent it, so true
		for(int i=0;i<=noOfItems;i++) {
			dp[i][0]=1;
		}
		
		//if sum is not zero but the items are empty then we cant find any subset for given sum, hence false
		for(int i=1;i<=sum;i++) {
			dp[0][i]=0;
		}
		
		for(int i=1;i<=noOfItems;i++) {
			
			for(int j=1;j<=sum;j++) {
				
				//exclude the item if its value is greater than the sum
				if(arr[i-1]>j) {
					dp[i][j]=dp[i-1][j];
				}
				
				// check if you can include the item(2 options here either include the item or exclude it)
				else if(arr[i-1]<=j) {
					dp[i][j]=dp[i-1][j] + dp[i-1][j-arr[i-1]];
				}
			}
		}
		
		return dp[noOfItems][sum];
		
	}
	public static void main(String[] args) {
		int[] arr= {1,2,3,4};
		int sum=5;
		
		System.out.println(countNoOfSubsetsWithGivenSum(arr, sum));
	}

}
