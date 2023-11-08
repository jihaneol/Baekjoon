class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
         int delivery_cnt = 0;
         int pickup_cnt = 0;
        for(int i=n-1; i>-1; i--){
           
            delivery_cnt -= deliveries[i];
            pickup_cnt -= pickups[i];
            
            while(delivery_cnt < 0 || pickup_cnt < 0){
                delivery_cnt += cap;
                pickup_cnt += cap;
                answer+=((i+1)*2);
            }
        }
        
       
        return answer;
    }
}