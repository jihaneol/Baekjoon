class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int s=1;
        int e=1000000000;
       
        while(s<=e){
            long sum = 0;
            int level = (s+e)/2;
            boolean isSolve = true;
            for(int i=0; i<diffs.length; i++){
                if(diffs[i]<=level){
                    sum+=times[i];
                }else{
                    sum+=(times[i]+times[i-1])*(diffs[i]-level)+times[i];
                }
                
                if(limit<sum){
                    isSolve = false;
                    break;
                }
            }
            if(isSolve){
                answer = level;
                e= level-1;
            }else{
                s= level+1;
            }
            
        }
        return answer;
    }
}