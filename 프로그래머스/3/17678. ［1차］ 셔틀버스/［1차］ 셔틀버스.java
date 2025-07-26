import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        PriorityQueue<Integer> pq = new PriorityQueue();
        int[] departs = new int[n];
        departs[0] = 540;
        for(int i=1; i<n; i++){
            departs[i] = departs[i-1] + t;
        }
        
        for(String time : timetable){
            String[] split = time.split(":");
            int h = Integer.parseInt(split[0])*60;
            int min = Integer.parseInt(split[1]);
            pq.add(h+min);
        }
        //1~n-1 버스까지 태울수 있는 친구들 다 태운다.
        end: for(int i=0; i<n-1; i++){
            int depart = departs[i];
            for(int j=0; j<m; j++){
                if(pq.isEmpty()){
                    break end;
                }
                if(pq.peek()<=depart){
                    pq.poll();
                }else{
                    break;
                }
            }
        }
        int last = 0;
        // 마지막 버스일때 m-1번까지 태우고
        for(int i=0; i<m; i++){
            if(pq.isEmpty()){
                return intToTime(departs[n-1]);
            }
            if(pq.peek()<=departs[n-1]){
                last = pq.poll();
            }else{
                return intToTime(departs[n-1]);
            }
        }
        
        // 어떻게 마지막을 정리할까?
        // 1. 해당 되는게 없을때 도착시간.
        // 2. 해당 되는게 < m  면 도착시간.
        // 3. 해당 되는게 >= m 면 m번째 사람의 -1
        
        // m개면 마지막에 -1, m개 아니면 그 버스 도착 시간으로 정답 구하기
        
        
        return intToTime(last-1);
    }
    public String intToTime(int time){
        int h = time/60;
        int m = time%60;
        
        return String.format("%02d:%02d",h,m);
    }
}