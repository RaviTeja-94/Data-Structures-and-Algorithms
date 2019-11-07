import java.util.*;
class Program {
  public static int[] subarraySort(int[] array) {
    // Write your code here.
		int outOfOrderMin=Integer.MAX_VALUE;
		int outOfOrderMax=Integer.MIN_VALUE;
		if(array.length<2)
		{
			return new int[]{-1,-1};
		}
		
		for(int i=0;i<array.length;i++)
		{
			if(isOutOfOrder(i,array)){
				outOfOrderMin=Math.min(outOfOrderMin,array[i]);
				outOfOrderMax=Math.max(outOfOrderMax,array[i]);
			}
		}
		System.out.println(outOfOrderMin+ " "+ outOfOrderMax);
		if(outOfOrderMin==Integer.MAX_VALUE)
		{
			 return new int[]{-1,-1};
		}
		int outOfOrderMinIndex=0, outOfOrderMaxIndex=array.length-1;
		while(outOfOrderMin>=array[outOfOrderMinIndex]){
			outOfOrderMinIndex++;
		}
		while(outOfOrderMax<=array[outOfOrderMaxIndex]){
			outOfOrderMaxIndex--;
		}
		
		return new int[]{outOfOrderMinIndex,outOfOrderMaxIndex};
  }
	
	private static boolean isOutOfOrder(int i,int[] array){
		if(i==0 )
		{
			return array[i]>array[i+1];
		}
		if(i==array.length-1)
		{
			return array[i]<array[i-1];
		}
		return array[i-1]>array[i]  || array[i+1]<array[i];
		
	}
}
