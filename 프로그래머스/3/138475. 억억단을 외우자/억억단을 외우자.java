import java.util.*;
class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] dp = new int[e+1];
        Arrays.fill(dp,1);
        count(dp,e);     
        Map<Integer,Integer> map = new HashMap();
        Integer[] tmp = Arrays.
            stream(starts.clone()).boxed().toArray(Integer[] :: new);
        
        Arrays.sort(tmp,Collections.reverseOrder());
        int start = e;
        int max = 0;
        int idx = 0;
        for(int end : tmp){
            for(int i=start; i>=end; i--){
                if(max<=dp[i]) {
                    max = dp[i];
                    idx = i;
                }
            }
            map.put(end,idx);
            start = end;
        }
        for(int i=0; i<starts.length; i++){
            answer[i] = map.get(starts[i]);
        }
        return answer;
    }
    public void count(int[] dp, int n){
        for(int i=2; i<=n; i++){
            dp[i]++;
            for(int j=2; j*i<=n; j++){
                dp[i*j]++;
            }
        }
    }
}