import java.util.*;
class Solution {
    public String[] solution(String[] s) {
        List<String> answer = new ArrayList();
        // 110
        StringBuilder sb = new StringBuilder();
        for(String word : s){
            sb.setLength(0);
            int cnt = 0;
            for(int i=0; i<word.length(); i++){
                sb.append(word.charAt(i));
                while(sb.length()>2 && sb.substring(sb.length()-3).equals("110")){
                    sb.delete(sb.length()-3, sb.length());
                    cnt++;
                }
            }
            
            int zeroIdx = sb.lastIndexOf("0");
            while(cnt-->0){
                sb.insert(zeroIdx+1,"110");
            }
            answer.add(sb.toString());
        }
       
        return answer.toArray(String[]::new);
    }
}