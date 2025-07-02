import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList();
       
        int origin_day_type = ymdToInt(today);
        
        Map<String, Integer> term = new HashMap();
        
        for(String t : terms){
            String a[] = t.split(" ");
            term.put(a[0], Integer.parseInt(a[1])*28);
        }

        for(int i=0; i<privacies.length; i++){
            String privacie = privacies[i];
            
            String info = privacie.substring(privacie.length()-1, 
                                             privacie.length());
            
            String period =  privacie.substring(0, privacie.length()-2);
            
            
            int comp_day_type = ymdToInt(period)+term.get(info);
            
            if(origin_day_type >= comp_day_type) {
                answer.add(i+1);
            }  
            
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    public int ymdToInt(String term){
        String[] ymd = term.split("\\.");
        int year = Integer.parseInt(ymd[0]);
        int month = Integer.parseInt(ymd[1]);
        int day = Integer.parseInt(ymd[2]);
        
        return year*28*12 + month*28 + day;
    }
}