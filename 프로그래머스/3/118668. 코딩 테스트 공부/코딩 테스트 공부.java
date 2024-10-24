import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {

         int goal_a=0;
         int goal_c=0;
        //목표치를 구하는 for문
       for(int[] p : problems){
            goal_a=Math.max(p[0],goal_a);
            goal_c=Math.max(p[1],goal_c);
        }

        if(goal_a<=alp && goal_c<=cop) return 0;
        
        alp = Math.min(alp, goal_a);
        cop = Math.min(cop, goal_c);

        int[][] dp =new int[goal_a+1][goal_c+1];

        for(int i=alp;i<=goal_a;i++){
            for(int j=cop;j<=goal_c;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }

        dp[alp][cop]=0;

         for(int i=alp;i<=goal_a;i++){
            for(int j=cop;j<=goal_c;j++){
                if(i<goal_a) dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                if(j<goal_c) dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
                
                for(int[] p : problems){
                    if(i<p[0] || j<p[1]) continue;
                    int next_a = Math.min(goal_a, p[2]+i);
                    int next_c = Math.min(goal_c, p[3]+j);
                    dp[next_a][next_c] = Math.min(dp[next_a][next_c]
                                                 ,dp[i][j]+p[4]);
                }
            }
         }
        return dp[goal_a][goal_c];
    }


}