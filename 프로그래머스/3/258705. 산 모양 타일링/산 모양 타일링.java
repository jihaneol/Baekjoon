class Solution {
    public int solution(int n, int[] tops) {
        final int MOD = 10007;
        int dp[][] = new int[n+1][2]; 
        dp[0][0] = 1; 
     
        
        for(int i=1; i<=n; i++){
            dp[i][0] = (dp[i-1][0]*(tops[i-1]+2) + dp[i-1][1]*(tops[i-1]+1))%MOD;
            dp[i][1] = (dp[i-1][0] + dp[i-1][1])%MOD;
            
        }
        
        
        return (dp[n][1]+dp[n][0])%MOD;
    }
}