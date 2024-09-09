import java.util.*;
class Solution {
    private Map<String,List<String>> ticketMap = new HashMap();
    private Map<String,Integer> visited = new HashMap();
    private int len;
    private String arrive = "";
    
    public String[] solution(String[][] tickets) {
        len = tickets.length;
        for(String[] ticket : tickets){
            String s = ticket[0];
            String e = ticket[1];
            if(visited.containsKey(s+e)){
                visited.put(s+e,visited.get(s+e)+1);
            }else{
                visited.put(s+e,1);
            }
            if(ticketMap.containsKey(s)){
                ticketMap.get(s).add(e);
            }else{
                ticketMap.put(s,new ArrayList());
                ticketMap.get(s).add(e);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<(len+1)*3; i++){
            sb.append('Z');
        }
        arrive = sb.toString();
        dfs(0,"ICN",new StringBuilder("ICN"));

        String[] answer = new String[len+1];
        for(int i=0; i<arrive.length(); i+=3){
            answer[i/3] = arrive.substring(i,i+3);
        }
        return answer;
    }
    public void dfs (int depth, String s, StringBuilder sb){
        if(depth==len){
            if(arrive.compareTo(sb.toString())>0){
                arrive = sb.toString();
            }
            return;
        }
        if(!ticketMap.containsKey(s)) return;
        for(String e : ticketMap.get(s)){
            String key = s+e;
            if(visited.get(key)!=0){
                visited.put(s+e,visited.get(key)-1);
                sb.append(e);
                dfs(depth+1, e, sb);
                sb.delete(sb.length()-3,sb.length());
                visited.put(s+e,visited.get(key)+1);
            }
            
        }
    }
}