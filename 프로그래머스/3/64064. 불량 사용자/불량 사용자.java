import java.util.*;
class Solution {
    private Set<String> set = new HashSet();
    private int answer;
    public int solution(String[] user_id, String[] banned_id) {
        
        solve(user_id, banned_id, new boolean[user_id.length], 0);
        
        return answer;
    }
    public void solve(String[] user_id, String[] banned_id, boolean[] visited, int depth){
        // 다 확인 했다면
        if(depth == banned_id.length){
            String temp = "";
            for(int i=0; i<visited.length; i++){
                if(visited[i]){
                    temp += i;
                }
            }
            if(!set.contains(temp)){
                set.add(temp);
                answer++;
                System.out.println(temp);
            }
            return;
        }
        
        String ban = banned_id[depth];
        
        notban:for(int i=0; i<user_id.length; i++){
            if(visited[i]) continue;
            
            String user = user_id[i];
            
            if(user.length() == ban.length()){
                for(int j=0; j<user.length(); j++){
                    if(ban.charAt(j)!='*'&&ban.charAt(j)!=user.charAt(j)){
                        continue notban;
                    }
                }
                
                visited[i] = true;
                solve(user_id, banned_id, visited, depth+1);
                visited[i] = false;
            }
        }
        
        return;
        
        
    }

}