package InsertionSort;

import java.util.Random;

//	O(n^2)
public class InsertionSort {
	public static int N = 1000;
	public static int MAX_NUM = 10000;
	public static int steps = 0;

	public static void main(String[] args) {
		System.out.println("Size of list: "+N);
		System.out.println("Max int of list allowed: "+MAX_NUM);
		int[] list = createList();
		System.out.println("UNSORTED: "+print(list));
		long timeBefore = System.nanoTime();
		list = insertionSort(list);
		long timeAfter= System.nanoTime();
		long timeDelayed = timeAfter - timeBefore;
		System.out.println("SORTED: "+print(list));
		System.out.println("Steps: "+steps);
		System.out.println("Time delayed: "+timeDelayed+"ns");

	}
	
	public static String print(int[] list) {
		String res = "[ ";
		for(int i : list) {
			res = res.concat(i+" ");
		}
		res = res.concat("]");
		return res;
	}
	
	public static int[] insertionSort(int list[]){ 
        int n = list.length;
        for(int i=0; i<n; i++) {
        	int k = i;
        	for(int j=i-1; j>=0 && list[k] < list[j]; j--) {
        		steps++;
        		int temp = list[j]; 
                list[j] = list[k]; 
                list[k] = temp;
                k = j;
        	}
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
