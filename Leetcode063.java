package test;

//DP，此题考虑bottom up比较简单，iterate可由for循环实现
public class Leetcode063 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] mark = new int[m][n];
        
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++) {
                if (obstacleGrid[i][j] == 1)
                    mark[i][j] = 0;
                else {
                    if (i == 0 && j == 0)
                        mark[i][j] = 1;
                    else if (i == 0 && j != 0)
                        mark[i][j] = mark[i][j-1];
                    else if (i != 0 && j == 0)
                        mark[i][j] = mark[i-1][j];
                    else if (i != 0 && j != 0)
                        mark[i][j] = mark[i-1][j] + mark[i][j-1];
                }
            }
        
        return mark[m-1][n-1];
    }
}