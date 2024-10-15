import java.util.*;
class Solution {
    private int[][] dp;
    private final int INF = Integer.MAX_VALUE;
    public int[] solution(int target) {
        dp = new int[target+1][2]; // 0 은 횟수 , 1은 볼/싱글 횟수
        for(int i=0; i<=target; i++){
            dp[i][0] = INF;
        }
        dp[0][0] = 0;
       
        return play(target);
    }
    
    // 바트업 방식의 코드 구현
    public int[] play(int n){
        
        if(dp[n][0]!=INF) return dp[n];
        
        if(n-50>=0){
            int[] tmp = play(n-50); // 최소 보장;
            if(dp[n][0]>tmp[0]+1 || (dp[n][0]==tmp[0]+1 && tmp[1]+1>dp[n][1])){
                dp[n][0] = tmp[0] + 1;
                dp[n][1] = tmp[1] + 1;
            }
        }
        
        for(int i=1; i<4; i++){
            for(int score=1; score<21; score++){
                if(n-score*i<0) break;
                int[] tmp = play(n-score*i);
                int cnt = i==1 ? 1 : 0;
                if(dp[n][0]>tmp[0]+1 || (dp[n][0]==tmp[0]+1 && tmp[1]+cnt>dp[n][1])){
                    dp[n][0] = tmp[0] + 1;
                    dp[n][1] = tmp[1] + cnt;
                }
            }
        }
        
        
        return dp[n];
      
    }
}