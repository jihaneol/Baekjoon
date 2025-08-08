import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
     
        // 선물을 가장 많이 받을 친구의 선물 수 구하기
        // 선물 지수 맵
        Map<String, Integer> scoreMap = new HashMap();
        // 관계도
        Map<String, Integer> relationMap = new HashMap();
        for(String f : friends){
            scoreMap.put(f, 0);
        }
        for(String gift : gifts){
            String[] split = gift.split(" ");
            String a = split[0];
            String b = split[1];
            
            relationMap.put(gift, relationMap.getOrDefault(gift,0)+1);
            
            scoreMap.put(a, scoreMap.get(a)+1);
            scoreMap.put(b, scoreMap.get(b)-1);
        }
        int n = friends.length;
        int[] answer = new int[n];
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                String a = friends[i];
                String b = friends[j];
                
                // 기록이 있는지 확인
                int relation_a = relationMap.getOrDefault(a+" "+b,-1);
                int relation_b = relationMap.getOrDefault(b+" "+a,-1);
                if(relation_a!=-1 || relation_b!=-1){ // 기록이 있다.
            
                    if(relation_a>relation_b) answer[i]++;
                    else if(relation_b>relation_a) answer[j]++;
                    else{
                         int score_a = scoreMap.get(a);
                            int score_b = scoreMap.get(b);
                            if(score_a>score_b){
                                answer[i]++;
                            }else if(score_b>score_a){
                                answer[j]++;
                            }
                    }
                }else{
                      // 기록이 없다면 지수확인..
                // 지수 확인
                int score_a = scoreMap.get(a);
                int score_b = scoreMap.get(b);
                if(score_a>score_b){
                    answer[i]++;
                }else if(score_a<score_b){
                    answer[j]++;
                }
                }
              
            }
        }
    
   
        return Arrays.stream(answer).max().orElse(-1);
    }
}