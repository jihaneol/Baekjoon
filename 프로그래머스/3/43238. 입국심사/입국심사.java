import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        // 심사관 10만명
        
        // n명 10억명 
        
        // 심사관 기다리는 초 10억분...
        
        long s = 0;
        long e = 1000000000l*1000000000;
        while(s<e){
            long mid = (s+e)/2; // 처리 시간
            long sum = 0; // 통과한 사람 수
            for(int time : times){
                sum += (mid/time);
            }
            if(n<=sum){
                e=mid;
                answer=mid;
            }else if(n>sum){
                s=mid+1;
            }
        }
        
        return answer;
    }
}