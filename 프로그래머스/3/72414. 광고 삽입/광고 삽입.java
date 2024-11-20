
class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int play = convertTime(play_time);
        int e = convertTime(adv_time);
        int s = 0;
        
        int[] playTimeArr = new int[play+2];
        
        for(String log : logs){
            String[] temp = log.split("-");
            int s_log = convertTime(temp[0]);
            int e_log = convertTime(temp[1]);
            
            playTimeArr[s_log]++;
            playTimeArr[e_log]--;
        }
        
        for(int i=1; i<play+1; i++){
            playTimeArr[i] +=playTimeArr[i-1];
        }
        long total = 0;
        int adv_start_anser = 0;
        //초기
        for(int i=0; i<=e; i++){
            total+=playTimeArr[i];
        }
        long max = total;
        
        // 슬라이딩
        for(int i=e; i<play; i++){
            total-=playTimeArr[i-e];
            total+=playTimeArr[i];
            
            if(max<total){
                max = total;
                adv_start_anser = i-e+1;
            }
        }

        return convertString(adv_start_anser);
    }
    private int convertTime(String now){
        String[] time = now.split(":");
        int hour = Integer.parseInt(time[0])*3600;
        int minute = Integer.parseInt(time[1])*60;
        int sec = Integer.parseInt(time[2]);
        return hour + minute + sec;
    }
    
    private String convertString(int time){
        StringBuilder sb = new StringBuilder();
        int hour = time/3600;
        time%=3600;
        int minute = time/60;
        time%=60;
        int sec = time;
        if(check(hour)){
            sb.append(hour);
        }else{
            sb.append(0).append(hour);
        }
        sb.append(":");
        
         if(check(minute)){
            sb.append(minute);
        }else{
            sb.append(0).append(minute);
        }
          sb.append(":");
        
         if(check(sec)){
            sb.append(sec);
        }else{
            sb.append(0).append(sec);
        }
        return sb.toString();
    }
    private boolean check(int time){
        if(time<10) return false;
        return true;
    }
}