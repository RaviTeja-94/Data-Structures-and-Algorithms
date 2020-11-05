class Program {
  public static int[] bubbleSort(int[] array) {
    // Write your code here.
		int len=array.length;
		for(int i=0;i<len-1;i++)
		{
			boolean swap=false;
			for(int j=0;j<len-i-1;j++)
			{
				if(array[j]>array[j+1])
				{
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
					swap=true;
				}
			}
			if(swap == false)
			{
				break;
			}
		}
		return array;
  }
}
