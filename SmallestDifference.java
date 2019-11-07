import java.util.*;
class Program {
  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
		/*int prevAbsDiff=Integer.MAX_VALUE;
		int curAbsDiff=0,elem1=0,elem2=0;
		for(int i=0;i<arrayOne.length;i++) {
			for(int j=0;j<arrayTwo.length;j++) {
			
					 curAbsDiff=Math.abs(arrayOne[i]-arrayTwo[j]);
			
			
				if(curAbsDiff<prevAbsDiff) {
						prevAbsDiff=curAbsDiff;
						elem1=arrayOne[i];
					
						elem2=arrayTwo[j];
					
					}
				}
			}
		return new int[]{elem1,elem2};*///O(n^2)

		//O(nlog(n)+mlog(m))
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		int it1=0;
		int it2=0;
		int overAllSmallestDiff=Integer.MAX_VALUE;
		int currentSmallestDiff=Integer.MAX_VALUE;
		int[] resPair=new int[2];
		while(it1<arrayOne.length && it2<arrayTwo.length){
			if(arrayOne[it1]==arrayTwo[it2]) 
				return new int[]{arrayOne[it1],arrayTwo[it2]};
			currentSmallestDiff=Math.abs(arrayOne[it1]-arrayTwo[it2]);
			if(currentSmallestDiff<overAllSmallestDiff){
				overAllSmallestDiff=currentSmallestDiff;
				resPair[0]=arrayOne[it1];
				resPair[1]=arrayTwo[it2];
			}
			if(arrayOne[it1]<arrayTwo[it2]){
				it1++;
			}
			else if(arrayOne[it1]>arrayTwo[it2]){
				it2++;
			}	
		}
		return resPair;
  }
}

