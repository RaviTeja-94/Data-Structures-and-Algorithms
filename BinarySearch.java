class Program {
  public static int binarySearch(int[] array, int target) {
    // Write your code here
		int start=0;
		int end=array.length-1;
		int mid;
		while(start<=end)
		{
		 mid=(start+end)/2;
			if(array[mid]<target){
				start=mid+1;
			}
			else if(array[mid]>target){
				end=mid-1;
			}
			else {
				return mid;
			}
		}
		return -1;
  }
}
