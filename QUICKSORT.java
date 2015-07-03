package test;

public class QUICKSORT {

	int temp;
	
	public static void main(String args[]) {
		int A[] = {3,1,2,18,5,16,12,14,19,1,2,3,15,31,65,47,23};
		int length = A.length - 1;
		QUICKSORT test = new QUICKSORT();
		test.quicksort(A, 0, length);
		for(int i = 0; i < A.length; i++)
			System.out.println(A[i] + " ");
	}
	
	void quicksort(int[] A, int start, int end) {
		if (start < end) {
			int q = partition(A, start, end);
			quicksort(A, start, q-1);
			quicksort(A, q+1, end);
		}
	}
	
	int partition(int[] A, int start, int end) {
		int x = A[end];
		int i = start - 1;
		for(int j = start; j < end; j++) {
			if (A[j] <= x) {
				i++;
				temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		temp = A[i+1];
		A[i+1] = A[end];
		A[end] = temp;
		return i+1;
	}
}
