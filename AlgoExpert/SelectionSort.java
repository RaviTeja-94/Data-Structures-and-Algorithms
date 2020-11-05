

class Program {
  public static int[] selectionSort(int[] array) {
    // Write your code here.
  	int MINVAL;
		int minIndex = -1;;
		for(int i=0;i<array.length-1;i++)
		{
			MINVAL = Integer.MAX_VALUE;
			for(int j=i;j<array.length;j++)
			{
				if(array[j]<MINVAL)
				{
					MINVAL=array[j];
					minIndex=j;
				}
				
			}
			array[minIndex]=array[i];
			array[i]=MINVAL;
		}
		return array;
	}
}
