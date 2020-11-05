import java.util.*;

class Program {
  public static int[] twoNumberSum(int[] array, int targetSum) {
		Arrays.sort(array);
		for(int start=0,target=array.length-1;start<target;){
		
			if (array[start]+array[target]==targetSum){
				return new int[] {array[start],array[target]};
			
			}
			else if (array[start]+array[target]<targetSum){
				start++;
			}
			else {
				target--;
			}
		}
		return new int[]{};
		
  }
}
