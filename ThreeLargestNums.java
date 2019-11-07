import java.util.Arrays;

class Program {
  public static int[] findThreeLargestNumbers(int[] array) {
    // Write your code here.
		int fmax=Integer.MIN_VALUE;
		int smax=Integer.MIN_VALUE;
		int tmax=Integer.MIN_VALUE;
		for(int i=0;i<array.length;i++){
		
			if(array[i]>fmax){
				tmax=smax;
				smax=fmax;
				fmax=array[i];
			}
			else if(array[i]>smax){
				tmax=smax;
				smax=array[i];
			}
			else if(array[i]>tmax) {
				tmax=array[i];
			}
		
		}
		int[] res= new int[]{fmax,smax,tmax};
		Arrays.sort(res);
		return res;
		
  }
}
