class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        // 2는 직진만 가능하다. 0으로 채우기..
        // 1는 통행 금지. 0으로 채우기
        // dp[옆, 위][x][y] 옆은 0
        n = cityMap.length;
        m = cityMap[0].length;
        
        int[][][] dp = new int[2][n][m];
        
        // 위쪽 채우기
        for(int i=1; i<m; i++){
            if(cityMap[0][i]==1){
                break;
            }
            dp[0][0][i] = 1;
        }
        
        //옆쪽 채우기
        for(int i=1; i<n; i++){
            if(cityMap[i][0]==1){
                break;
            }
            dp[1][i][0] = 1;
        }
        
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(cityMap[i][j]==1) continue;
                
                // 옆
                if(cityMap[i][j-1]==2){
                    dp[0][i][j] += dp[0][i][j-1];
                }else{
                    dp[0][i][j] += dp[0][i][j-1] + dp[1][i][j-1];
                }
                     
                // 위
                if(cityMap[i-1][j]==2){
                    dp[1][i][j] += dp[1][i-1][j];
                }else{
                    dp[1][i][j] += dp[1][i-1][j] + dp[0][i-1][j];
                }
                dp[0][i][j] %= MOD;
                dp[1][i][j] %= MOD;
                
            }

        }
        
        return (dp[0][n-1][m-1]+dp[1][n-1][m-1])%MOD;
    }
}