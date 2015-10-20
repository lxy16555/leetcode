package test;

public class Leetcode072 {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        
        int[][] ans = new int[l1+1][l2+1];
        
        for (int i=0; i<l1+1; i++)
            ans[i][0] = i;
        for (int i=0; i<l2+1; i++)
            ans[0][i] = i;
        
        for (int i=1; i<l1+1; i++) {
            for (int j=1; j<l2+1; j++) {
                if (word1.charAt(i-1) != word2.charAt(j-1))
                    ans[i][j] = 1 + minimum(ans[i-1][j], ans[i][j-1], ans[i-1][j-1]);
                else
                    ans[i][j] = minimum(ans[i-1][j]+1, ans[i][j-1]+1, ans[i-1][j-1]);
            }
        }
        return ans[l1][l2];
    }
    
    public int minimum(int a, int b, int c) {
        if (a < b)
            return a < c ? a : c;
        else
            return b < c ? b : c;
    }
}