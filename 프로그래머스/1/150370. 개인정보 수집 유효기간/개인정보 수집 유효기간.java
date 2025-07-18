import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termMap = new HashMap();
        for(String term : terms){
            String[] split = term.split(" ");
            termMap.put(split[0], Integer.parseInt(split[1])*28);
        }
        
        int now = dayToInt(today);
        List<Integer> answer = new ArrayList();
        for(int i=0; i<privacies.length; i++){
            String[] privacie = privacies[i].split(" ");
            int ymd = dayToInt(privacie[0]);
            if(now >= ymd + termMap.get(privacie[1])){
                answer.add(i+1);
            }
        }
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    public int dayToInt(String today){
        String[] ymd = today.split("\\.");
        
        int y = Integer.parseInt(ymd[0])*28*12;
        int m = Integer.parseInt(ymd[1])*28;
        int d = Integer.parseInt(ymd[2]);
        return y+m+d;
    }
}