//The algorithm is for maximum 6 digit numbers.
public class SortingExample {

	public static void main(String[] args) {
		
		
		int[] data = {845621, 54242, 162569, 161350};
		radixSort(data);
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}
	
	
	
	public static void radixSort (int[] arr) { //This is the method that represents the program
		int criteria = 1;      //Meaning that we start from the right digit, sort, and move to left everytime sorting based on the digit
		sort(arr, criteria);
	}
	
	
	
	
	private static void sort(int[] arr, int criteria) {  //This method sorts the values based on the criterion digit.
		SinglyLinkedList[] L = new SinglyLinkedList[10];   //An array of linked lists, literally our buckets.
		for(int i = 0; i < 10; i++)         //Every element should be initialized separately.
			L[i] = new SinglyLinkedList();
		if(6 < criteria) 
			return;
		for(int i = 0; i <10; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(digitAtFromRight(arr[j], criteria) == i) 
					L[i].addLast(arr[j]);
			}
		}
		enumerate(L, arr);   //In this step we enumerate the content of the buckets into the initial array.
		sort(arr, criteria + 1);  //recurisely we move from the right digit to the left one, everytime sorting again
	}
	

	private static int digitAtFromRight (int num, int place) {   //This method returns the digit in the intended place.
		int digit = 0;
		for(int i = 1; i <= place; i ++) {
			digit = num % 10;
			num = num / 10;
		}
		return digit;
	}
	
	

	private static void enumerate(SinglyLinkedList[] L, int[] arr) {  
		int positionInArray = 0;
		for(int i = 0; i < 10; i++) {
			if(!L[i].isEmpty()) 
				positionInArray = L[i].listToMatrixInt(arr, positionInArray);
		}
	}
}
