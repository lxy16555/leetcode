package test;

//同上一题类似，不需要存储可能答案及正确答案，返回值改为int读取成功个数
public class Leetcode052 {
    //判断下一个插入点是否有效
    public boolean isValid(int[] strs, int row, int column) {
        for (int i=0; i<row; i++)
            if (column == strs[i] || column-row == strs[i]-i || column+row == strs[i]+i)
                return false;

        return true;
    }

    //插入有效解
    public int findAns(int ans, int[] strs, int n, int count) {
        if (count == n) {
            ans++;
            return ans;
        }

        for (int i=0; i<n; i++) {
            if (isValid(strs, count, i)) {
                strs[count] = i;
                count++;
                ans = findAns(ans, strs, n, count);
            } else 
                continue;
            strs[count-1] = -1;
            count--;
        }
		
        return ans;
    }
	
    public int totalNQueens(int n) {
        int ans = 0;
        int[] strs = new int[n];
        
        return findAns(ans, strs, n, 0);
    }
}