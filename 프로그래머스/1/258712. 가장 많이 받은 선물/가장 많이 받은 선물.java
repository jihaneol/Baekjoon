import java.util.*;
class Solution {
    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;
        Map<String, Integer> friendIndex = new HashMap();
        int[][] friendMap = new int[n][n];
        int[] giftScore = new int[n];
        
        for(int i=0; i<n; i++){
            friendIndex.put(friends[i],i);
        }
        
        for(String g : gifts){
            String[] giftName = g.split(" ");
            int aIndex = friendIndex.get(giftName[0]);
            int bIndex = friendIndex.get(giftName[1]);
            
            giftScore[aIndex]++;
            giftScore[bIndex]--;
            friendMap[aIndex][bIndex]++;
        }
        
        for(int i=0; i<n; i++){
            int num = 0;
            for(int j=0; j<n; j++){
                if(i==j) continue;
              
                if(friendMap[i][j] > friendMap[j][i] ||
                   (friendMap[i][j] == friendMap[j][i] && giftScore[i] > giftScore[j])){
                    num++;
                }
            }
            answer = Math.max(answer,num);
        }
        return answer;
    }
    
        
}