package sort;

public class 정렬정리 {

	
	public static void swap(int[] list, int a, int b) {
		int tmp = list[a];
		list[a] = list[b];
		list[b] = tmp;
	}
	public static void print(int[] list) {
		for(int i=0; i<list.length; i++) {
			System.out.print(list[i]+" ");
		}
		System.out.println();
	}
	
	//선택 정렬 : O(n^2)
	public static void selection_sort(int[] list) {
		int least;
		
		for(int i=0; i<list.length-1; i++) {
			least = i;
			for(int j=i+1; j<list.length; j++) {
				if(list[j]<list[least]) least=j;
			}
			swap(list, least, i);
		}
		print(list);
	}
	
	//삽입정렬 : O(n^2)
	public static void insertion_sort(int[] list) {
		int key;
		for(int i=1; i<list.length; i++) {
			key = list[i];
			for(int j=i-1; j>=0 && list[j]>key; j--) {
				list[j+1] = list[j];
			}
			list[i] = key;
		}
		
		print(list);
	}
	
	//버블 정렬 : O(n^2)
	public static void bubble_sort(int[] list) {
		
		for(int i=list.length-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				if(list[j]>list[j+1])
					swap(list, i, j);
			}
		}
		print(list);
	}
	
	//합병정렬 : O(nlog2n)
	public static void merge_sort(int[] arr, int left, int right) {
		 if (right - left < 2) {
			 return;
		 }
	     int mid = (left + right) / 2;
	     merge_sort(arr, 0, mid);
	     merge_sort(arr, mid, right);
	     merge(arr, left, mid, right);
	}
	private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left];
        int t = 0, l = left, h = mid;

        while (l < mid && h < right) {
            if (arr[l] < arr[h]) {
                temp[t++] = arr[l++];
            } else {
                temp[t++] = arr[h++];
            }
        }

        while (l < mid) {
            temp[t++] = arr[l++];
        }

        while (h < right) {
            temp[t++] = arr[h++];
        }

        for (int i = left; i < right; i++) {
            arr[i] = temp[i - left];
        }
    }
	
	//퀵정렬 :O(nlog2n)
	public static int partition(int list[], int left, int right) {
		int pivot;
		int low, high;
		low = left;
		high = right + 1;
		pivot = list[left];
		
		do {
			do 
				low++;
			while(list[low]<pivot);
			do
				high--;
			while(list[high]>pivot);
			if(low<high) swap(list, low, high);
			
		}while(low<high);
		
		swap(list, left, high);
		
		return high;
	}
	 static void quick_sort(int list[], int left, int right)
     {
	   
       if(left < right)
         int q = partition(list, left, right);
         quick_sort(list, left, q-1);
         quick_sort(list, q+1, right);
     }
	
	public static void main(String[] args) {
		int[] list= {6,5,7,4,4,3};
		selection_sort(list);
		insertion_sort(list);
		bubble_sort(list);
		merge_sort(list, 0, list.length);
		quick_sort(list, 0, list.length);
		

	}

}
