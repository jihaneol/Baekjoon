import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        // want 값 map에 넣기
        Map<String, Integer> map = new HashMap();
        for(int i=0; i<want.length; i++){
            map.put(want[i], number[i]);
        }
        
        for(int i=0; i<discount.length-9; i++){
            Map<String, Integer> target = new HashMap();
            
            for(int j=i; j<i+10; j++){
                target.put(discount[j], target.getOrDefault(discount[j],0)+1);
            }
            
            if(map.equals(target)) 
                answer++;
            
        }
        
        return answer;
    }
}