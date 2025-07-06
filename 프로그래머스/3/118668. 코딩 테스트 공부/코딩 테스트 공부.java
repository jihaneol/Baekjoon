import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        // 최단 시간
        // 알고 풀이 능력, 코딩 풀이 능력, 알고 보상, 코딩 보상, 시간 비용
        int maxa = 0, maxc = 0;
        // 알고력, 코딩력의 1씩 증가하는걸 dp에 모두 더해준다.
        for(int[] problem : problems){
            maxa = Math.max(maxa, problem[0]);
            maxc = Math.max(maxc, problem[1]);
        }
        if(alp>=maxa) alp = maxa;
        if(cop>=maxc) cop = maxc;
        
        int[][] dp = new int[maxa+2][maxc+2];
        
        for(int i=alp; i<=maxa; i++){
            for(int j=cop; j<=maxc; j++){
                  dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        // 알고력, 코딩력을 순차적으로 이동한다.
        // problem에 맞게 dp를 갱신해준다.
        dp[alp][cop] = 0;
        for(int i=alp; i<=maxa; i++){
            for(int j=cop; j<=maxc; j++){
                for(int[] problem : problems){
                    // 못풀면 다음
                    if(i<problem[0] || j<problem[1])
                        continue;
                    // 풀었을때 얻는 능력을 갱신
                    int nextI = i + problem[2] > maxa ? maxa : i + problem[2];
                    int nextJ = j + problem[3] > maxc ? maxc : j + problem[3];
                    
                    dp[nextI][nextJ] = Math.min(dp[nextI][nextJ], 
                                                              dp[i][j] + problem[4]);
                    
                }
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + 1);
                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j] + 1);
            }
        }
        
        return dp[maxa][maxc];

    }


}