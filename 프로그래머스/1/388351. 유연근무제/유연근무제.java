class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        // (startday+i)%7 == 6, 0 넘어가. 
        for(int i=0; i<schedules.length; i++){
            int startTime = schedules[i];
            boolean flag = true; // 상 받을 수 있는지
            int[] log = timelogs[i];
            for(int j=0; j<7; j++){
                if((j+startday)%7==6 || (j+startday)%7==0) continue;

                if(change(startTime+10)<log[j]){
                    flag = false;
                    break;
                }
            }
            
            if(flag) answer++;
        }
        return answer;
    }
    public int change(int time){
        int m = time%100;
        int h = time/100;
        if(m>=60){
            h++;
            m-=60;
        }
        return h*100 + m;
    }
}