import java.util.Scanner;

public class QuickSort {
	
	public static void main(String s[]) {
		Scanner sc = new Scanner (System.in);
		int noOfElements = sc.nextInt();
		int arr[]=new int[noOfElements];
		for(int i=0;i<noOfElements;i++) {
			arr[i]=sc.nextInt();
		}
		int l = arr.length;
		QuickSort q = new QuickSort();
		q.sort(arr,0,l-1);
		q.printArray(arr, l);
        sc.close();
	}
	
	private void sort(int[]arr, int low, int high) {
		if(low<high) {
			int p = partition(arr,low,high);
			sort(arr,low,p-1);
			sort(arr,p+1,high);
		}
	}
	
	private int partition(int[] arr, int low, int high) {
		int i= low-1;
		for(int j=low;j<high;j++) {
			if(arr[j]<=arr[high]) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i]=temp;
				
			}
		}
		int temp=arr[high];
		arr[high]=arr[++i];
		arr[i]=temp;
		
		return i;
	}

	void printArray(int a[], int n)  
	{  
	    int i;  
	    for (i = 0; i < n; i++)  
	        System.out.print(a[i]+" ");
	}  

}
