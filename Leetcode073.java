package test;

//矩阵归零问题，次优解，空间复杂度为O(m+n)
public class Leetcode073 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] col = new int[m];
        int[] row = new int[n];
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == 0) {
                    col[i] = 1;
                    row[j] = 1;
                }
            }
        }
        
        for (int i=0; i<m; i++) {
            if (col[i] == 1) {
                for (int j=0; j<n; j++)
                    matrix[i][j] = 0;
            }
        }
        
        for (int i=0; i<n; i++) {
            if (row[i] == 1) {
                for (int j=0; j<m; j++)
                    matrix[j][i] = 0;
            }
        }
    }
}