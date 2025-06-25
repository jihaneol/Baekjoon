import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        /**
        신고된 유저, 신고당한 횟수
        유저, 유저가 신고한 id
        
        각 유저가 받은 메일 수 return
        **/
        
        int[] answer = new int[id_list.length];
        Map<String, Integer> banMap = new HashMap();
        Map<String, List<String>> userMap = new HashMap();
        Set<String> set = new HashSet();
        // 신고하기
        for(String r : report){
            if(set.contains(r)){
                continue;
            }
            set.add(r);
            String[] split = r.split(" ");
            String user = split[0];
            String banId = split[1];
            
            banMap.put(banId, banMap.getOrDefault(banId, 0)+1);
            if(!userMap.containsKey(user)){
                userMap.put(user, new ArrayList());
            }
            userMap.get(user).add(banId);
        }
        
        // 계산하기
        for(int i=0; i<id_list.length; i++){
            String user = id_list[i];
            int count = 0;
            if(!userMap.containsKey(user)){
                answer[i] = count;
                continue;
            }
            
            for(String banId : userMap.get(user)){
                if(banMap.get(banId)>=k){
                    count++;
                }
            }
            
            answer[i] = count;

        }
        
        
        
        return answer;
    }
}