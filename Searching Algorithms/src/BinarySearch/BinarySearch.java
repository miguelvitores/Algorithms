package BinarySearch;

import java.util.Random;

//	O(log2(n))
public class BinarySearch {
	public static int N = 1000;
	public static int MAX_NUM = 1000;
	public static int steps = 0;

	public static void main(String[] args) {
		System.out.println("Size of list: "+N);
		System.out.println("Max int of list allowed: "+MAX_NUM);
		int[] list = createList();
		System.out.println("UNSORTED: "+print(list));
		list = selectionSort(list);
		System.out.println("SORTED: "+print(list));
		Random r = new Random();
		int searchedNum = list[r.nextInt(N)];
		System.out.println("Searching: "+searchedNum);
		int low = 0;
		int top = N;
		if( binarySearch(list, low, top, searchedNum) ) {
			System.out.println("Found!");
			System.out.println("Steps: "+steps);
		}else {
			System.out.println("Not found :(");
		}

	}
	
	public static String print(int[] list) {
		String res = "[ ";
		for(int i : list) {
			res = res.concat(i+" ");
		}
		res = res.concat("]");
		return res;
	}
	
	public static int[] selectionSort(int list[]){ 
        int n = list.length; 
  
        for (int i = 0; i < n-1; i++){
            int min_idx = i; 
            for (int j = i+1; j < n; j++) {
                if (list[j] < list[min_idx]) 
                    min_idx = j; 
            }

            int temp = list[min_idx]; 
            list[min_idx] = list[i]; 
            list[i] = temp; 
        }
        return list;
    } 
	
	public static int[] createList() {
		int[] list = new int[N];
		for(int i=0; i<N; i++) {
			list[i] = new Random().nextInt(MAX_NUM);
		}
		return list;
	}
	
	public static boolean binarySearch(int[] list,int low, int top, int searchedNum) {
		if(top>=low) {
			steps++;
			int mid = low + (top - low) / 2;
			
			if(list[mid]==searchedNum) {
				System.out.println(list[mid]+"=="+searchedNum);
				return true;
			}else if(list[mid] > searchedNum) {
				System.out.println(list[mid]+">"+searchedNum);
				return binarySearch(list, low, mid, searchedNum);
			}else {
				System.out.println(list[mid]+"<"+searchedNum);
				return binarySearch(list, mid, top, searchedNum);
			}
		}
		return false;
	}

}
