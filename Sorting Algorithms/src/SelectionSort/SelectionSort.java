package SelectionSort;

import java.util.Random;

//	O(n^2)
public class SelectionSort {
	public static int N = 10;
	public static int MAX_NUM = 100;
	public static int steps = 0;

	public static void main(String[] args) {
		System.out.println("Size of list: "+N);
		System.out.println("Max int of list allowed: "+MAX_NUM);
		int[] list = createList();
		System.out.println("UNSORTED: "+print(list));
		list = selectionSort(list);
		System.out.println("SORTED: "+print(list));
		System.out.println("Steps: "+steps);

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
            	steps++;
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

}
