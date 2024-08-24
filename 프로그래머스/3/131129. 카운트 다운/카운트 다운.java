import java.util.*;
class Solution {
    int[][] dp;
    final int INF = Integer.MAX_VALUE;
    public int[] solution(int target) {
        int[] answer = new int[2];
        //최선의 경우 던질 다트 수, 그때의 싱글/불을 맞춘 횟수의 합
        
        //점수, 던진 횟수, 싱글/볼을 맞춘 횟수
        //dp[i][0] = c, 점수: i, 던진 횟수: c
        //dp[i][1] = s, 싱글/불 맞춘 횟수: s
        
        dp = new int[target+1][2];
        for(int i=0; i<=target; i++){
            dp[i][0] = INF;
        }
        dp[0][0] = 0;
        
        return play(target);
    }
    public int[] play(int n){
        
        if(dp[n][0]==INF){
            //불 계산
            if(n>=50){
                int[] temp = play(n-50);
                if(dp[n][0]>temp[0]+1 ||(dp[n][0]==temp[0]+1 && temp[1]+1>dp[n][1])){
                    dp[n][0] = temp[0] + 1;
                    dp[n][1] = temp[1] + 1;
                }
            }
            // 트리플 더블 싱글 계산
            int t = n>=20? 20 : n;
            for(int i=t; i>0; i--){
                for(int j=1; j<4; j++){
                    if(n>=i*j){
                        int[] temp = play(n-i*j);
                        int cnt = j==1?1:0;
                        if(dp[n][0]>temp[0]+1 ||(dp[n][0]==temp[0]+1 && temp[1]+cnt>dp[n][1])){
                            dp[n][0] = temp[0] + 1;
                            dp[n][1] = cnt + temp[1];
                        }
                    }
                }
            }

        }
       
        return dp[n];
    }
}