package test;

//������䷽������ζ�ȡ����һ������
public class Leetcode059 {
    //����ʵ�֣��������ҷֱ���ǰһ����1
    public void insert(int[][] matrix, int n, int count) {
        if (2*count >= n)
            return;
        
        for (int i=count; i<n-count; i++) {
            if (i == 0)
                continue;
            matrix[count][i] = matrix[count][i-1]+1;
        }
        for (int i=count+1; i<n-count; i++)
            matrix[i][n-1-count] = matrix[i-1][n-1-count]+1;
        for (int i=n-1-count-1; i>=count; i--)
            matrix[n-1-count][i] = matrix[n-1-count][i+1]+1;
        for (int i=n-1-count-1; i>count; i--)
            matrix[i][count] = matrix[i+1][count]+1;
        
        insert(matrix, n, count+1);
    }
    
    //���õ�������������base���������matrix
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        if (n == 0)
            return matrix;
        
        matrix[0][0] = 1;
        insert(matrix, n, 0);
        
        return matrix;
    }
}