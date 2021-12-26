import java.util.Scanner;

public class MergeSortAndInversionCount {
	
	public static void main(String s[]) {
		Scanner sc = new Scanner (System.in);
		int noOfElements = sc.nextInt();
		int arr[]=new int[noOfElements];
		for(int i=0;i<noOfElements;i++) {
			arr[i]=sc.nextInt();
		}
		int l = arr.length;
		MergeSortAndInversionCount mg = new MergeSortAndInversionCount();
		int count = mg.sort(arr,0,l-1);
		System.out.println("Inversion count "+count);
		mg.printArray(arr, l);
        sc.close();
	}
	
	private int sort(int []arr, int l , int r) {
		int count=0;
		if(l<r) {
			int mid = (l+r)/2;
			count += sort(arr,l,mid);
			count += sort(arr,mid+1,r);
			count += merge(arr, l , mid ,r);
		}
		return count;
	}

	private int merge(int[] arr, int l, int mid, int r) {
		//System.out.println(arr+" "+l+" "+mid+" "+r);
		int n1 = mid-l+1;
		int n2 = r-mid;
		int inversioncount = 0;
		int arr1[]= new int[n1];
		int arr2[]= new int[n2];
		
		for(int i = 0 ; i<n1;++i) {
			arr1[i] = arr[l+i];
		}
		
		for(int j = 0 ; j<n2;++j) {
			arr2[j] = arr[mid+1+j];
		}
		
		int i = 0;
		int j = 0;
		int k = l;
		while(i<n1 && j<n2) {
			if(arr1[i]<= arr2[j]) {
				arr[k]=arr1[i];
				i++;
			}
			else {
				arr[k]=arr2[j];
				j++;
				inversioncount++;
			}
			k++;
		}
		
		while(i<n1) {
			arr[k]= arr1[i];
			i++;
			k++;
			inversioncount++;
		}
		
		while(j<n2) {
			arr[k]= arr2[j];
			j++;
			k++;
		}
		return inversioncount;
		
	}
	
	void printArray(int a[], int n)  
	{  
	    int i;  
	    for (i = 0; i < n; i++)  
	        System.out.print(a[i]+" ");
	}  

}
