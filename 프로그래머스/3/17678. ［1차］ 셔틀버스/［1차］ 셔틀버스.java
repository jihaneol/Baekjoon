import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
   
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        for(String time : timetable){
            String[] split = time.split(":");
            int h = Integer.parseInt(split[0])*60;
            int min = Integer.parseInt(split[1]);
            pq.add(h+min);
        }
        int time = 0;
        //1~n-1 버스까지 태울수 있는 친구들 다 태운다.
        for(int i=0; i<n; i++){
            int depart = 540+i*t;
            int boarded = 0;
            while(!pq.isEmpty() && pq.peek()<=depart && boarded<m){
                int crew = pq.poll();
                if(i==n-1) time = crew-1;
                boarded++;
            }
            
            if(i==n-1 && boarded<m){
                time = depart;
            }
        }
        
        return intToTime(time);
    }
    public String intToTime(int time){
        int h = time/60;
        int m = time%60;
        
        return String.format("%02d:%02d",h,m);
    }
}