import java.util.*;
class Solution {
    private int[][][] dp;
    private int[][] location = {{3,1},{0,0},{0,1},{0,2}
                                     ,{1,0},{1,1},{1,2}
                                     ,{2,0},{2,1},{2,2}};
    private final int INF = 10000000;
    public int solution(String numbers) {
        dp = new int[10][10][numbers.length()+1]; // 왼,오,순서
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                Arrays.fill(dp[i][j],INF);
            }
        }
        dp[4][6][0] = 0;
       for(int depth=0; depth<numbers.length(); depth++){
           int num = numbers.charAt(depth)-'0';
        for(int left = 0; left<10; left++){
            for(int right = 0; right<10 ;right++){
                if(left==right) continue;
              if(dp[left][right][depth] != INF){
                   
                  dp[num][right][depth+1] = 
                      Math.min(dp[left][right][depth]+distance(num,left)
                                          , dp[num][right][depth+1]);
                dp[left][num][depth+1] = 
                    Math.min(dp[left][right][depth]+distance(num,right)
                                                  , dp[left][num][depth+1]);
              }  
            }
        }
        
       }
        int n = numbers.length()-1;
        int end = numbers.charAt(n) - '0';
        int answer = INF;
        for(int i=0; i<10; i++){
           answer = Math.min(answer
                    ,Math.min(dp[i][end][n+1],dp[end][i][n+1]));
        }
        
       
        return answer;
    }
    
    public int distance(int x, int y){
        int a = Math.abs(location[x][0]-location[y][0]);
        int b = Math.abs(location[x][1]-location[y][1]);
        
        if(a==0 && b==0) return 1;
        else if(a==0 || b==0){
            return  a>b ? a*2 : b*2;
        }else{
            return a==b? a*3: (a+b)*2-1;
        }
    }
}