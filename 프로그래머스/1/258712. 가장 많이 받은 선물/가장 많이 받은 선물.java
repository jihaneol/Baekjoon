import java.util.*;
class Solution {
    private Map<String, Integer> indexMap = new HashMap();
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        
        int[] answer = new int[n];
        int[] scoreArr = new int[n];
        int[][] giftRelation = new int[n][n];
        
        for(int i=0; i<friends.length; i++){
            indexMap.put(friends[i], i);
        }
        
        for(String gift : gifts){
            String[] split = gift.split(" ");
            
            int a = indexMap.get(split[0]);
            int b = indexMap.get(split[1]);
            
            scoreArr[a] += 1;
            scoreArr[b] -= 1;
            
            giftRelation[a][b]+=1;
        }
        
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                
                if(giftRelation[i][j] == giftRelation[j][i]){
                    if(scoreArr[i] > scoreArr[j]) answer[i]+=1;
                    else if(scoreArr[i] < scoreArr[j]) answer[j]+=1;
                    continue;
                }

                if(giftRelation[i][j]>giftRelation[j][i]) answer[i]+=1;
                else if(giftRelation[i][j]<giftRelation[j][i]) answer[j]+=1;
            }
        }
        
        
        return Arrays.stream(answer).max().orElse(-1);
    }
}