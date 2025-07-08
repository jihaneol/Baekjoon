import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
     
        // diff = 현재 퍼즐 난이도, time_cur = 현재 퍼즐 소요 시간, lv = 내 숙련도
        int s = 1;
        int e = Arrays.stream(diffs).max().orElse(0);
        
        while(s<e){
            int lv = (s+e)/2;
            int time_prev = 0;
            long total_time = 0;
            for(int i=0; i<diffs.length; i++){
                int diff = diffs[i];
                int time_cur = times[i];
                
                if(diff <= lv) {
                    total_time += time_cur;
                }else{
                    total_time += (diff - lv)*(time_cur + time_prev) + time_cur;
                }
                time_prev = time_cur;
            }
            
            // limit 넘어 가면 lv 키우기
            if(total_time>limit){
                s = lv+1;
            }else{
            
                e = lv;
            }
            
            
        }
        
        return s;
    }
}