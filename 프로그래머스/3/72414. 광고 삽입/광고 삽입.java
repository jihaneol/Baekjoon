class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        // 36만이하 sliding window 하면 되겠는데.. 0~내 길이 adv_time
        // -> 끝까지 해서  가장큰 시작위치 찾으면 끝..
        int n = timeToInt(play_time);
        int len = timeToInt(adv_time);
        int[] playArr = new int[n+1];
        
        // 로그 길이 30만
        for(String log : logs){
            String[] split = log.split("-");
            int s = timeToInt(split[0]);
            int e = timeToInt(split[1]);
            playArr[s]++;
            playArr[e]--;
        }
        
        for(int i=1; i<=n; i++){
            playArr[i] +=playArr[i-1];
        }
        
      
        int s_max = 0; // 공익 광고 시작 시간
        long pre = 0; // 이전 최대 시간
        for(int i=0; i<len; i++){
            pre+=playArr[i];
        }
        long max = pre; // 공익 광고 최대 시간
        
        // 슬라이딩 윈도우
        for(int s=1; s<=n-len; s++){
            int e = s+len;
            long now = pre-playArr[s-1] + playArr[e-1]; 
            
            if(now>max){
                max=now;
                s_max = s;
            }
            pre = now;
        }
        
        return intToTime(s_max);
    }
    public int timeToInt(String time){
        String[] split = time.split(":");
        int h = Integer.parseInt(split[0]) * 60 * 60;
        int m = Integer.parseInt(split[1]) * 60;
        int s = Integer.parseInt(split[2]);
        
        return h + m + s;
    }
    public String intToTime(int time){
        int h = time/3600;
        time%=3600;
        int m = time/60;
        int s = time%60;
        
        return String.format("%02d:%02d:%02d",h,m,s);
    }
}