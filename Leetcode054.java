package test;

//回形读取数组，迭代或循环均可
public class Leetcode054 {
    //迭代本体，每次一个循环，然后增加count数量
    public void addSpiral(int[][] matrix, int m, int n, List<Integer> ans, int count) {
        if (2*count >=m || 2*count >= n)
            return;
        
        for (int i=count; i<n-count; i++)
            ans.add(matrix[count][i]);
        for (int i=count+1; i<m-count; i++)
            ans.add(matrix[i][n-1-count]);
        if (2*count != m-1)
            for (int i=n-1-count-1; i>=count; i--)
                ans.add(matrix[m-1-count][i]);
        if (2*count != n-1)
            for (int i=m-1-count-1; i>count; i--)
                ans.add(matrix[i][count]);
        count++;
        addSpiral(matrix, m, n, ans, count);
    }
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        
        if (matrix.length == 0)
            return ans;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        addSpiral(matrix, m, n, ans, 0);
        
        return ans;
    }
}