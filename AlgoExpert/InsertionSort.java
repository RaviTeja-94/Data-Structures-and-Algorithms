class Program {
  public static int[] insertionSort(int[] array) {
    // Write your code here.
		for(int i=0;i<array.length-1;i++)
		{
			for(int j=i+1;j>0;j--)
			{
				if(array[j]<array[j-1])
				{
					int temp=array[j];
					array[j]=array[j-1];
					array[j-1]=temp;
				}
			}
		}
		
		return array;
  }
}
