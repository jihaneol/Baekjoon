class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        // 0, 6 은 무시
        for(int s=0; s<schedules.length; s++){
            int start = convert(schedules[s]);
            int[] log = timelogs[s];
            boolean flag = true;
            for(int t=0; t<7; t++){
                if((t+startday)%7==6 || (t+startday)%7==0)
                    continue;
                
                if(log[t]>start){
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        
        return answer;
    }
    private int convert(int time){
        int h = time/100;
        int m = time%100+10;
        
        if(m>=60){
            h++;
            m%=60;
        }
        
        return h*100 + m; 
    }
}