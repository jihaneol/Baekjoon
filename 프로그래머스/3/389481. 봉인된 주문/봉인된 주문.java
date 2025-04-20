import java.util.*;
class Solution {
    public String solution(long n, String[] bans) {
        
        PriorityQueue<Long> pq = new PriorityQueue();
        
        for(String b : bans){
            pq.add(convertStringToInt(b));
        }
        
        while(!pq.isEmpty()){
            long num = pq.poll();
            
            if(n>= num) n++;
            else break;
        }
        
        
        return convertIntToString(n);
    }
    private long convertStringToInt(String s){
        
        char[] ban = s.toCharArray();
        int len = s.length();
        long result = 0;
        
        for(int i=0; i<len; i++){
            int alp = ban[i] - 'a' + 1;
            long digit = len - i -1;
            result += ((long) Math.pow(26,digit)* alp);
        }
        
        return result;
    }
    private String convertIntToString(long num){
        StringBuilder result = new StringBuilder();

        while(num>0){
            // 첫자리 알파벳 찾기
            long digit = num%26;
            if(digit==0) {
                result.append('z');
                num= (num-26)/26;
            }
            else {
                result.append((char)('a'+(digit-1)));
                num= (num-digit)/26;
            }
        }
     

        return result.reverse().toString();
    }
    
}