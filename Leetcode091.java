public class Solution {
    //DP问题，dp[i]=dp[i+1]+dp[i+2]或者dp[i]=dp[i+1]如果不能组成双数，注意考虑0的情况
    public int numDecodings(String s) {
        if (s.length() == 0)
            return 0;
            
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        
        for (int i=n-1; i>=0; i--) {
            if (s.charAt(i) == '0')
                dp[i] = 0;
            else if (i<n-1 && (s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<='6')))
                dp[i] = dp[i+1] + dp[i+2];
            else
                dp[i] = dp[i+1];
        }
        
        return dp[0];
    }
}
