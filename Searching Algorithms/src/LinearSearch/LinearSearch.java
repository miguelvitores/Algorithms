package LinearSearch;

import java.util.Random;

//	O(n)
public class LinearSearch {
	public static int N = 100;
	public static int MAX_NUM = 10;

	public static void main(String[] args) {
		System.out.println("Size of list: "+N);
		System.out.println("Max int of list allowed: "+MAX_NUM);
		int[] list = createList();
		int steps = searchRandomInt(list);
		System.out.println("Steps: "+steps);

	}
	
	public static int[] createList() {
		int[] list = new int[N];
		for(int i=0; i<N; i++) {
			list[i] = new Random().nextInt(MAX_NUM);
		}
		return list;
	}
	
	public static int searchRandomInt(int[] list) {
		Random r = new Random();
		int x = list[r.nextInt(N)];
		int steps = 0;
		
		for(int i=0; i<N; i++) {
			steps++;
			if(list[i]==x) {
				System.out.println(list[i]+"=="+x);
				break;
			}else {
				System.out.println(list[i]+"!="+x);
			}
		}
		
		return steps;
	}

}
