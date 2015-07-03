package test;

public class MERGESORT {
	
	public static void main(String args[]) {
		int A[] = {3,1,2,18,5,16,12,14,19,1,2,3,15,31,65,47,23};
		MERGESORT test = new MERGESORT();
		test.DEVIDE(A, 0, A.length - 1);
		for(int i=0; i<A.length; i++)
			System.out.println(A[i]);
	}
	
	void DEVIDE(int[] A, int start, int end) {
		if(start < end) {
			int q = (end + start) / 2;
			DEVIDE(A, start, q);
			DEVIDE(A, q+1, end);
			MERGE(A, start, end, q);
		}
	}
	
	void MERGE(int[] A, int start, int end, int q) {
		int L[] = new int[q - start + 1];
		int R[] = new int[end - q];
		for(int i=0; i<L.length; i++) {
			L[i] = A[start + i];
		}
		for(int i=0; i<R.length; i++) {
			R[i] = A[q + 1 + i];
		}
		
		int i = 0;
		int j = 0;
		for(int k = start; k<=end; k++) {
			if(i < L.length && j < R.length) {          //当i或j溢出时java不能识别，必须手动比较
				if(L[i] <= R[j]) {
					A[k] = L[i];
					i++;
				} else {
					A[k] = R[j];
					j++;
				}
			} else if(i < L.length) {
				A[k] = L[i];
				i++;
			} else {
				A[k] = R[j];
				j++;
			}
		}
	}
}
