import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
      
        // 선물 지수 = 준 선물 수 - 받은 선물 수
        // 더 많이 선물 받은 사람이 다음에 선물을 받는다.
        Map<String, Integer> tradeMap = new HashMap();
        Map<String, Integer> scoreMap = new HashMap();
        
        for(String f : friends){
            scoreMap.put(f, 0);
        }
        
        for(String gift : gifts){
            tradeMap.put(gift, tradeMap.getOrDefault(gift, 0)+1);
            String[] split = gift.split(" ");
            
            scoreMap.put(split[0], scoreMap.getOrDefault(split[0],0)+1);
            scoreMap.put(split[1], scoreMap.getOrDefault(split[1],0)-1);
        }
        int n = friends.length;
        
        int[] answer = new int[n];
        
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                String a = friends[i];
                String b = friends[j];
                
                // 거래 내역 확인하기.
                int tradeA = tradeMap.getOrDefault(a+" "+b, 0);
                int tradeB = tradeMap.getOrDefault(b+" "+a, 0);
                
                if((tradeB==0 && tradeA==0)||tradeA==tradeB){
                    int scoreA = scoreMap.get(a);
                    int scoreB = scoreMap.get(b);
                    if(scoreA>scoreB){
                        answer[i]++;
                    }else if(scoreB>scoreA){
                        answer[j]++;
                    }
                }else if(tradeA>tradeB){
                    answer[i]++;
                }else{
                    answer[j]++;
                }
            }
        }
        
        // 가장 많이 선물 받을 친구의 선물 수 구하기.
        return Arrays.stream(answer).max().orElse(-1);
    }
}