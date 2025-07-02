class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
    
        int total = 0;
        int deltotal = 0;
        int picktotal = 0;
        long answer = 0;
        for(int i=n-1; i>=0; i--){
            int del = deliveries[i];
            int pick = pickups[i];
            
            // 배달 && 수거
            deltotal +=del;
            picktotal +=pick;
            
            while(total< deltotal || total< picktotal){
                answer+=(i+1);
                total+=cap;
            }
        }
        return answer*2;
    }
}