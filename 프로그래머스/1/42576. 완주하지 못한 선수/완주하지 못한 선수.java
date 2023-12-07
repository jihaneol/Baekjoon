import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> map = new HashMap();
       
        for(String p : participant) map.put(p,map.getOrDefault(p,0)+1);
        for(String c : completion) map.computeIfPresent(c, (k,v)-> v-1);
        
        for(String k : map.keySet()){
            if(map.get(k)!=0){
                answer = k;
                break;
            }
        }
        return answer;
    }
}  