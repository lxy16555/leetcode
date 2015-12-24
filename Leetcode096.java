public class Solution {
    //上一题的简化版，求有多少种不必列出来，dp[i]=dp[i/2]*dp[i/2]，即左边的可能性乘以右边的可能性，所有值相加
    public int numTrees(int n) {
        int[] ans = new int[n+1];
        ans[0] = 1;
        ans[1] = 1;
        for (int i=2; i<=n; i++) {
            ans[i] = 0;
            if (i % 2 != 0)
                ans[i] = ans[(i-1)/2] * ans[(i-1)/2];
            for (int j=0; j<i/2; j++) {
                ans[i] += 2 * ans[j] * ans[i-1-j];
            }
        }
        
        return ans[n];
    }
}
