package test;

//��2D�������Ƿ���target������һ�뷨binary research
public class Leetcode074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        return binarySearch(0, 0, m-1, n-1, matrix, target);
    }
    
    //�������зֱ�����
    public boolean binarySearch(int startM, int startN, int endM, int endN, int[][] matrix, int target) {
        //���ȿ����б仯��ע��startM����Ҫ+1
        if (startM != endM) {
            int m = (startM + endM) / 2;
            if (matrix[m][endN] < target) {
                startM = m+1;
                return binarySearch(startM, startN, endM, endN, matrix, target);
            } else if (matrix[m][endN] > target) {
                endM = m;
                return binarySearch(startM, startN, endM, endN, matrix, target);
            } else {
                return true;
            }
        } else {
            if (startN == endN)
                    return (matrix[startM][startN] == target);
            
	    //�����б仯��ע��startNÿ��ҲҪ+1��endN����-1
            int n = (startN + endN) / 2;
            if (matrix[startM][n] < target) {
                startN = n+1;
                return binarySearch(startM, startN, endM, endN, matrix, target);
            } else if (matrix[startM][n] > target) {
                endN = n;
                return binarySearch(startM, startN, endM, endN, matrix, target);
            } else {
                return true;
            }
        }
    }
}