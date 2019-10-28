package QuickSort;

import java.util.Random;

//	O(n^2)
public class QuickSort {
	public static int N = 256000;
	public static int MAX_NUM = 256000;
	public static int steps = 0;
	public static Random rnd = new Random();

	public static void main(String[] args) {
		System.out.println("Size of list: "+N);
		System.out.println("Max int of list allowed: "+MAX_NUM);
		int[] list = createList();
//		System.out.println("UNSORTED: "+print(list));
		long timeBefore = System.nanoTime();
		quickSort(list, 0, list.length-1);
		long timeAfter= System.nanoTime();
		long timeDelayed = timeAfter - timeBefore;
//		System.out.println("SORTED: "+print(list));
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
	
	public static void quickSort(int[] list, int low, int top){
		if(low < top) {
			int pivotIndex = partition(list, low, top);
			quickSort(list, low, pivotIndex-1);
			quickSort(list, pivotIndex+1, top);
        }
    }
	
	public static int partition(int[] list, int low, int top) {
		int pivotIndex = low + rnd.nextInt(top-low);
		int pivot = list[pivotIndex];
		
		int i = low;
		for(int j=low; j<top+1; j++) {
			if(i == pivotIndex) {
				i++;
			}
			if(j == pivotIndex) {
				j++;
			}
			if(list[j] < pivot) {
				int temp = list[j]; 
                list[j] = list[i]; 
                list[i] = temp;
                i++;
			}
		}
		if(i>pivotIndex) {
			i--;
		}
		int temp = list[i]; 
        list[i] = list[pivotIndex]; 
        list[pivotIndex] = temp;
		
		return i;
	}
	
	public static int[] createList() {
		int[] list = new int[N];
		for(int i=0; i<N; i++) {
			list[i] = new Random().nextInt(MAX_NUM);
		}
		return list;
	}

}
