package test;

//DP，同上两题
public class Leetcode064 {
    public int MIN(int a, int b) {
        return a < b ? a : b;
    }
    
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] mark = new int[m][n];
        
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++) {
                if (i == 0 && j == 0)
                    mark[i][j] = grid[i][j];
                else if (i == 0 && j != 0)
                    mark[i][j] = mark[i][j-1] + grid[i][j];
                else if (i != 0 && j == 0)
                    mark[i][j] = mark[i-1][j] + grid[i][j];
                else if (i != 0 && j != 0)
                    mark[i][j] = MIN(mark[i-1][j], mark[i][j-1]) + grid[i][j];
            }
        
        return mark[m-1][n-1];
    }
}