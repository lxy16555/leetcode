package test;

public class INSERTSORT {
	
	public static void main(String args[]) {
		int A[] = {3,1,2,18,5,16,12,14,19,1,2,3,15,31,65,47,23};
		int B[] = new int[A.length];
		INSERTSORT test = new INSERTSORT();
		test.INSERT(A, B);
		for(int i=0; i<B.length; i++)
			System.out.println(B[i]);
	}
	
	void INSERT(int[] A, int[] B) {
		for(int i=0; i<A.length;i++) {
			for(int j=i-1; j>=-1; j--) {
				if(j<0) {
					B[j+1] = A[i];
					break;
				}
				if(B[j] <= A[i]) {
					B[j+1] = A[i];
					break;
				} else {
					B[j+1] = B[j];
					B[j] = A[i];
				}
			}
		}
	}
}
