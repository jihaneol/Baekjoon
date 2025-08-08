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
        int answer = 0;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=0; j<n; j++){
                if(i==j) continue;
                String a = friends[i];
                String b = friends[j];
                
                // 기록이 있는지 확인
                int relation_a = relationMap.getOrDefault(a+" "+b,-1);
                int relation_b = relationMap.getOrDefault(b+" "+a,-1);
                int score_a = scoreMap.get(a);
                int score_b = scoreMap.get(b);
                
                if(relation_a>relation_b || (relation_a==relation_b && score_a>score_b)){
                    sum++;
                }
            }
            answer = Math.max(answer, sum);
        }
    
   
        return answer;
    }
}