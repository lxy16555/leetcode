package test;

public class Leetcode001 {
	public int[] towSum(Node[] num, int target) {
		int[] index = new int[2];
		int i = 0;
		int j = num.length - 1;
		while(num[i].number + num[j].number != target) {
			if(num[i].number + num[j].number > target)
				j--;
			else
				i++;
		}
		index[0] = num[i].index;
		index[1] = num[j].index;
		return index;
	}
	
	void quicksort(Node[] num, int start, int end) {
		if (start < end) {
			int q = partition(num, start, end);
			quicksort(num, start, q-1);
			quicksort(num, q+1, end);
		}
	}
	
	int partition(Node[] num, int start, int end) {
		Node temp;
		int x = num[end].number;
		int i = start - 1;
		for(int j = start; j < end; j++) {
			if (num[j].number <= x) {
				i++;
				temp = num[i];
				num[i] = num[j];
				num[j] = temp;
			}
		}
		temp = num[i+1];
		num[i+1] = num[end];
		num[end] = temp;
		return i+1;
	}
	
	public static void main(String args[]) {
		int array[] = {2, 11, 7, 15};
		int target = 9;
		Node nod[] = new Node[array.length];
		for(int i=0; i<array.length; i++)
			nod[i] = new Node(i+1, array[i]);
		
		Leetcode001 test = new Leetcode001();
		test.quicksort(nod, 0, array.length - 1);
		
		int[] index = new int[2];
		index = test.towSum(nod, target);
		System.out.println("index1 = " + index[0] + "\n" + "index2 = " + index[1]);
	}
}

class Node {
	public int index;
	public int number;
	
	Node(int ind, int num) {
		this.index = ind;
		this.number = num;
	}
}
