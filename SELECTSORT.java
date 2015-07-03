package test;

public class SELECTSORT {
	
	public static void main(String args[]) {
		int A[] = {3,1,2,18,5,16,12,14,19,1,2,3,15,31,65,47,23};
		SELECTSORT test = new SELECTSORT();
		test.SELECT(A);
		for(int i=0; i<A.length; i++)
			System.out.println(A[i]);
	}
	
	void SELECT(int[] A) {
		int temp1;
		int temp2;
		for(int i=0; i<A.length; i++) {
			temp1 = i;
			for(int j=i; j<A.length; j++)
				temp1 = (A[temp1]<=A[j]) ? temp1 : j;
			temp2 = A[temp1];
			A[temp1] = A[i];
			A[i] = temp2;
		}
	}
}
