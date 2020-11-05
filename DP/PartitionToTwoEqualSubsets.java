
public class PartitionToTwoEqualSubsets {
	
	
	/*
	 the sum of all elements in the give array has to be even number to divide the array into two equal sum subsets
	 so:
	 ->if the total sum is not even we cannot partition to two equal subsets
	 ->if even:
	 	->we have to check if we can find a subset with sum=sum/2, because if we have it into two equal sum subsets, each subset should have sum=sum/2
	 	->find a subset with sum=sum/2
	 	->if subset exists, we can partition otherwise we cannot
	 */
	public static boolean canPartitionToTwoEqualSumSubsets(int[] arr) {
		int sum=0;;
		int noOfItems = arr.length;
	
		for(int i=0;i<noOfItems;i++) {
			sum+=arr[i];
		}
		
		if(sum%2!=0) {
			return false;
		}
		
		boolean[][] dp = new boolean[noOfItems+1][(sum/2)+1];
		
		for(int i=0;i<=noOfItems;i++) {
			
			for(int j=0;j<=sum/2;j++) {
				
				if(i==0 || j==0) {
					dp[i][j]=false;
				}
				//exclude the item if its value is greater than the sum
				else if(arr[i-1]>j) {
					dp[i][j]=dp[i-1][j];
				}
				
				else if(arr[i-1]==j) {
					dp[i][j]=true;
				}
				// check if you can include the item(2 options here either include the item or exclude it)
				else if(arr[i-1]<j) {
					dp[i][j]=dp[i-1][j] || dp[i-1][j-arr[i-1]];
				}
			}
		}
		
		return dp[noOfItems][sum/2];
	}
	
	public static void main(String[] args) {
		
		int[] arr= {1,2,3};
		System.out.println(canPartitionToTwoEqualSumSubsets(arr));
	}
	
}
