class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int curc = 0;
        int curd = 0;
        int curp = 0;
        
        for(int i=n-1; i>=0; i--){
            curd += deliveries[i];
            curp += pickups[i];
            
            while(curd>curc || curp>curc){
                answer += (i+1)*2;
                curc += cap;
            }
        }
        
        return answer;
    }
}