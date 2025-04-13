import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
       
        int answer = 0; // 증설 횟수
        int[] servers = new int[24];
        
        for(int i=0; i<24; i++){
            int player = players[i]; // 게임 이용자의 수
            int n = servers[i];      // 증설된 서버의 수
            
            int need = player/m - n; // 필요한 서버 수
            
            if(need > 0){
                for(int j=0; j<k; j++){
                    if(i+j>=24) break;
                    servers[i+j] += need;
                }
                answer += need;
            }

        }
        return answer;
    }
}