class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        // 돈(10만원), 거슬러줄 돈(100종류), 가지수 구하기..
        int m = money.length;
        int[] dp = new int[n+1];
        for(int i=0; i<m; i++){
            int now = money[i]; // 현재 거스름돈
            dp[now]++;
            for(int j=now+1; j<=n; j++){
                dp[j] = (dp[j] + dp[j-now])%1_000_000_007;
            }
        }
        return dp[n];
    }
}