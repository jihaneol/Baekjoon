import java.util.*;
class Solution {
    int[][][] dp;
    final int INF = Integer.MAX_VALUE;
    public int solution(String numbers) {
        int answer = INF;
        dp = new int[10][10][numbers.length()+1];
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                Arrays.fill(dp[i][j],INF);
            }
        }
        dp[4][6][0] = 0;
        
        for(int t=0; t<numbers.length(); t++){
            int target = numbers.charAt(t)-'0';
            for(int i=0; i<10; i++){
                for(int j=0; j<10; j++){
                    if(i==j || dp[i][j][t]==INF) continue; 
                        if(target!=j){
                            dp[target][j][t+1] = Math.min(dp[target][j][t+1]
                                                 ,dp[i][j][t] + getOptimalValue(target,i));
                        }
                        if(target!=i){
                               dp[i][target][t+1] = Math.min(dp[i][target][t+1],
                                                  dp[i][j][t] + getOptimalValue(target,j));
                        }
           
                }
            }
        }
        int end = numbers.charAt(numbers.length()-1) - '0';
        for(int i=0; i<10; i++){
            if(dp[i][end][numbers.length()]<answer){
                    answer = dp[i][end][numbers.length()];
            }
            if(dp[end][i][numbers.length()]<answer){
                    answer = dp[end][i][numbers.length()];
            }
            
        }
        
        return answer;
    }
    
    private int getOptimalValue(int target, int key){
        int[] endPos = getPos(target);
        int[] startPos = getPos(key);
        int x = Math.abs(startPos[0] - endPos[0]); 
        int y = Math.abs(startPos[1] - endPos[1]);
        
        if(x==0 && y==0){ // 0일때
            return 1;
        }else if(x==0 || y==0){ // 직각
            return x>y? x*2 : y*2;
        }else {
            return x==y? x*3 : (x+y)*2-1;
            
        }

    }
      
    private int[] getPos(int num){
        int[] pos = {3,1};
        if(num==0){
            return pos;
        }
        int x = (num-1)/3;
        int y = (num-1)%3;
        pos[0] = x;
        pos[1] = y;
        return pos;
    }
    
}
   
  
