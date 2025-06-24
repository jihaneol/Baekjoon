import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList();
        // enter 유저 아이디, 닉네임
        // Leave 유저 아이디, 닉네임
        // Change 유저 아이디, 닉네임
        /**
        map<유저아이디, 닉네임>
        유저아이디님이 들어왔습니다.
        유저아이디님이 들어왔습니다.
        유저아이디님이 나갔습니다. 로 관리?
        
        님이 들어왔습니다. e q에 넣어?
        님이 나갔습니다.   l 
        1. q에 해당 명령어 앞글자랑 유저아이디를 넣는다.
        2. q에서 빼오면서 e면 님이 들어왔습니다. 로 answer에 넣는다.
        3. map에 유저아이디, 닉네임 을 저장한다.
        **/
        Queue<String> q = new LinkedList();
        Map<String, String> userMap = new HashMap();
        for(String r : record){
            String[] split = r.split(" ");
            
            if("Enter".equals(split[0])){
                q.add('e'+split[1]);
                userMap.put(split[1], split[2]);
            }
            else if("Leave".equals(split[0])){
                q.add('l'+split[1]);
            }
            else{
                userMap.put(split[1], split[2]);
            }
        }
        
        while(!q.isEmpty()){
            String s = q.poll();
            String nickname = userMap.get(s.substring(1));
            if('e'==s.charAt(0)){
                answer.add(nickname+"님이 들어왔습니다.");
            }
            else{
                answer.add(nickname+"님이 나갔습니다.");
            }
        }
        
        return answer.stream().toArray(String[]::new);
    }
}