import java.util.*;
class Program {
  public static int maxSubsetSumNoAdjacent(int[] array) {
    // Write your code here.
		//T=O(n),S=O(n)
		
		/*int[] maxSumArray=new int[array.length];
		if(array.length==0)
		{
			return 0;
		}
		else if(array.length==1)
		{
			return array[0];
		}
		else
		{
			if(array[0]>=array[1])
			{
				maxSumArray[0]=array[1];
				maxSumArray[1]=array[0];
			}
			else
			{
				maxSumArray[0]=array[0];
				maxSumArray[1]=array[1];
			}
			if(array.length==2)
			{
				return maxSumArray[1];
			}
			for(int i=2;i<array.length;i++)
			{
				System.out.println("first "+ maxSumArray[i-1]+" Second "+maxSumArray[i-2]+" current "+array[i]);;
				maxSumArray[i]=Math.max(maxSumArray[i-1],maxSumArray[i-2]+array[i]);
				System.out.println("After max"+maxSumArray[i]);
			}
			//System.out.println(maxSumArray[maxSumArray.length-1]);
			return maxSumArray[maxSumArray.length-1];
		}*/
		
		//T=O(n),S=O(1)
		
		int first,second,current=0;
		if(array.length==0)
		{
			return 0;
		}
		else if(array.length==1)
		{
			return array[0];
		}
		else
		{
			if(array[0]>=array[1])
			{
				first=array[1];
				second=array[0];
			}
			else
			{
				first=array[0];
				second=array[1];
			}
			if(array.length==2)
			{
				return second;
			}
			for(int i=2;i<array.length;i++)
			{
				
				current=Math.max(second,first+array[i]);
				first=second;
				second=current;
			}
			
			return second;
		}
  }
}
