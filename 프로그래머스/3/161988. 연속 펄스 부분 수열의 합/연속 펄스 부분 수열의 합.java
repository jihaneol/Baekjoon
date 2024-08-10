class Solution {
    public long solution(int[] sequence) {
        long sumPlus = 0;
        long sumMinus = 0;
        long answer = 0;
        int idx = 1;
        for(int seq : sequence){
            
            int pulse = seq*idx;
            if(sumPlus+pulse > pulse){
              
                sumPlus+=pulse;
            }else{
                sumPlus = pulse;
            }
            
            pulse = seq*idx*-1;
            if(sumMinus+pulse > pulse){
                sumMinus+=pulse;
            }else{
                sumMinus = pulse;
            }
            idx*=-1;
            answer = answer<sumPlus? sumPlus : answer<sumMinus? sumMinus : answer;
        
        }
        return answer;
    }
}