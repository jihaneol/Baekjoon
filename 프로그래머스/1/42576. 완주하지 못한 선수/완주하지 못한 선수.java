import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> map = new HashMap();
        for(String c : completion){
            if(!map.containsKey(c)){
                map.put(c,1);
            }else{
                map.computeIfPresent(c,(k,v) -> v+1);
            }
        }
        for(String p : participant){
            if(map.containsKey(p) && map.get(p)>0) map.computeIfPresent(p,(k,v)->v-1);
            else if(map.containsKey(p) && map.get(p)==0) {
                answer = p;
                break;
            }
            if(!map.containsKey(p)){
                answer = p;
                break;
            }
        }
        
        return answer;
    }
}  