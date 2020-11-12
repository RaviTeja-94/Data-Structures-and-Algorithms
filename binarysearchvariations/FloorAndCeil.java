package binarysearchvariations;

public class FloorAndCeil {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,7,8};
		int element=5;
		
		int floorElement = findFloor(arr, element);
		int ceilElement = findCeil(arr, element);
		
		System.out.println(floorElement);
		System.out.println(ceilElement);
		
		char[] charArray = {'a','b','f'};
		char letter = 'a';
		char nextcharacter = findNextCharAfterGivenChar(charArray, letter);
		
		if(nextcharacter!='#' ) {
			System.out.println(nextcharacter);
		}
		else {
			System.out.println("no next character to the given character found");
		}
		
	}

	private static int findCeil(int[] arr, int element) {
		int len=arr.length-1;
		int result=-1;
		int start=0;
		int end=len;
		
		while(start<=end) {
			int mid=start +(end - start)/2;
			
			if(arr[mid]==element) {
				result=element;
				break;
			}
			
			else if(arr[mid]<element) {	
				start=mid+1;
			}
			
			else if(arr[mid]>element) {
				result=arr[mid];
				end=mid-1;
			}
		}
		return result;
	}

	private static int findFloor(int[] arr, int element) {
		int len=arr.length-1;
		int result=-1;
		int start=0;
		int end=len;
		
		while(start<=end) {
			int mid=start +(end - start)/2;
			
			if(arr[mid]==element) {
				result=element;
				break;
			}
			
			else if(arr[mid]<element) {
				result=arr[mid];
				start=mid+1;
			}
			
			else if(arr[mid]>element) {
				end=mid-1;
			}
		}
		return result;
	}
	
	private static char findNextCharAfterGivenChar(char[] arr, char letter) {
		int start=0;
		int end=arr.length-1;
		char nextCharacter = '#';
		
		while(start<=end) {
			int mid= start +(end-start)/2;
			if(arr[mid]==letter) {
				start = mid+1;
			}
			
			else if(arr[mid]<letter) {
				start=mid+1;
			}
			else {
				nextCharacter=arr[mid];
				end=mid-1;
			}
		}
		
		return nextCharacter;
		
	}

}
