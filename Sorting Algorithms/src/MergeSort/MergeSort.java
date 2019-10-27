package MergeSort;

import java.util.Random;

//	O(nLog(n))
public class MergeSort {
	public static int N = 1000;
	public static int MAX_NUM = 10000;
	public static int steps = 0;

	public static void main(String[] args) {
		System.out.println("Size of list: "+N);
		System.out.println("Max int of list allowed: "+MAX_NUM);
		int[] list = createList();
		System.out.println("UNSORTED: "+print(list));
		long timeBefore = System.nanoTime();
		sort(list, 0, list.length-1);
		long timeAfter= System.nanoTime();
		long timeDelayed = timeAfter - timeBefore;
		System.out.println("SORTED: "+print(list));
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
	
	public static void sort(int list[], int low, int top){
		if(low < top) {
			int middle = (top+low)/2;
			sort(list, low, middle);
			sort(list, middle+1, top);
			int[] firstHalf = getSubarray(list, low, middle);
			int[] secondHalf = getSubarray(list, middle+1, top);
			int[] mergedList = merge(firstHalf, secondHalf);
			refreshArray(list, mergedList, low, top);
        }
    }
	
	public static void refreshArray(int list[], int mergedList[], int low, int top){
		for(int i=0, j=low; j<=top; i++, j++) {
			list[j] = mergedList[i];
		}
	}
	
	public static int[] getSubarray(int list[], int low, int top){
		int[] splittedList = new int[top+1-low];
		for(int i=0, j=low; i<splittedList.length; i++, j++) {
			splittedList[i] = list[j];
		}
		return splittedList;
	}
	
	public static int[] merge(int[] firstHalf, int[] secondHalf) {
		int tamMergedList = firstHalf.length + secondHalf.length;
		int[] mergedList = new int[tamMergedList];
		int i=0, j=0, k=0;
		while(k < tamMergedList) {
			if(i == firstHalf.length) {
				mergedList[k] = secondHalf[j];
				j++;
			}else if(j == secondHalf.length) {
				mergedList[k] = firstHalf[i];
				i++;
			}else {
				if(firstHalf[i] <= secondHalf[j] || j == secondHalf.length) {
					mergedList[k] = firstHalf[i];
					i++;
				}else if(firstHalf[i] > secondHalf[j] || i == firstHalf.length) {
					mergedList[k] = secondHalf[j];
					j++;
				}
			}
			k++;
		}
		
 
		return mergedList;
	}
	
	public static int[] createList() {
		int[] list = new int[N];
		for(int i=0; i<N; i++) {
			list[i] = new Random().nextInt(MAX_NUM);
		}
		return list;
	}

}
