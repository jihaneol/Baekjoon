class Solution {
    public String solution(String video_len, String pos, String op_start, 
                           String op_end, String[] commands) {
       
        int videoTime = makeTime(video_len);
        int nowTime = makeTime(pos);
        int s = makeTime(op_start);
        int e = makeTime(op_end);
        for(String comm : commands){
            // 오프닝 구간
            if(s<=nowTime && nowTime<=e){
                nowTime = e;
            }
            if(comm.equals("next")){
                nowTime = nowTime+10>=videoTime? videoTime:nowTime+10;
            }else{
                nowTime = nowTime-10<=0? 0:nowTime-10;
            }
            
            // 오프닝 구간
            if(s<=nowTime && nowTime<=e){
                nowTime = e;
            }
        }
        int h = nowTime/60;
        int m = nowTime%60;
      
        return timeToString(h) + ":" + timeToString(m);
    }
    public int makeTime(String time){
        String[] t = time.split(":");
        return Integer.parseInt(t[0])*60 + Integer.parseInt(t[1]);
    }
    public String timeToString(int t){
        if(t>9){
            return String.valueOf(t);    
        }
        
        return "0"+String.valueOf(t);
    }
}