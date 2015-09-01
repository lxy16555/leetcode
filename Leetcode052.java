package test;

//ͬ��һ�����ƣ�����Ҫ�洢���ܴ𰸼���ȷ�𰸣�����ֵ��Ϊint��ȡ�ɹ�����
public class Leetcode052 {
    //�ж���һ��������Ƿ���Ч
    public boolean isValid(int[] strs, int row, int column) {
        for (int i=0; i<row; i++)
            if (column == strs[i] || column-row == strs[i]-i || column+row == strs[i]+i)
                return false;

        return true;
    }

    //������Ч��
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