import java.util.*;
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
    
        // 시간 -> 정수로 변환
        int start = timeToInt(op_start);
        int end = timeToInt(op_end);
        int now = timeToInt(pos);
        int len = timeToInt(video_len);
        
        for(String command : commands){
            // 오프닝 위치인지 확인
            if(start<= now && now < end){
                now = end;
            }
            if("next".equals(command)){
                // 동영상 길이 넘으면 동영상 마지막 위치로
                now = now + 10 <= len ? now + 10 : len; 
            }else{
                // 0 이하면 0으로
                now = now - 10 >= 0 ? now - 10 : 0;
            }
        }
        // 오프닝 위치인지 확인
            if(start<= now && now < end){
                now = end;
            }
        
        return String.format("%02d:%02d", now/60, now%60);
    }
    public int timeToInt(String time){
        String[] split = time.split(":");
        int min = Integer.parseInt(split[0])*60;
        int sec = Integer.parseInt(split[1]);
        return min + sec; 
    }
//     public String IntToTime(int time){
        
//     }
}