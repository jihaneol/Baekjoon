import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i : scoville){
            pq.add(i);
        }
        
        while(!pq.isEmpty()){
            int num = pq.poll();
         
            if(num>=K){
                return answer;
            }
            
            if(pq.isEmpty()) break;
            
            int sub = pq.poll();
            
            pq.add(num+sub*2);
            answer++;
            
        }
        return -1;
    }
}