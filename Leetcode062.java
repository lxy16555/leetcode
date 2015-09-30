package test;

//DP问题，简单，注意DP的memorization和bottom up的时间问题
public class Leetcode062 {
    //定义数组存储变量
    public int uniquePaths(int m, int n) {
        int[][] mark = new int[m][n];
        
        return DP(m-1, n-1, mark);
    }
    
    //DP
    public int DP(int m, int n, int[][] mark) {
        if (m == 0 || n == 0)
            mark[m][n] = 1;
        else if (mark[m][n-1] != 0 && mark[m-1][n] != 0)
            mark[m][n] = mark[m][n-1] + mark[m-1][n];
        else if (mark[m][n-1] == 0 && mark[m-1][n] != 0)
            mark[m][n] = DP(m, n-1, mark) + mark[m-1][n];
        else if (mark[m][n-1] != 0 && mark[m-1][n] == 0)
            mark[m][n] = mark[m][n-1] + DP(m-1, n, mark);
        else if (mark[m][n-1] == 0 && mark[m-1][n] == 0)
            mark[m][n] = DP(m, n-1, mark) + DP(m-1, n, mark);
            
        return mark[m][n];
    }
}