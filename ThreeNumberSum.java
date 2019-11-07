import java.util.ArrayList;
import java.util.Arrays;

class Program {
  public static ArrayList<Integer[]> threeNumberSum(int[] array,  int targetSum) {
		Arrays.sort(array);
		ArrayList<Integer[]> triplets=new ArrayList<Integer[]>();
		int start,end;
		for(int i=0;i<array.length;i++)
		{
			for(start=i+1,end=array.length-1;start<end;)
			{
				int curSum= array[i]+array[start]+array[end];
				if(curSum==targetSum){
					Integer[] triplet={array[i],array[start],array[end]};
					triplets.add(triplet);
					start++;
					end--;
				}
				else if(curSum<targetSum)
				{
					start++;
				}
				else {
					end--;
				}
				
			}
			
		}
		return triplets;
		
  }
}
