import java.util.*;
class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] dp = new int[e+1];
        Arrays.fill(dp,1);
        count(dp,e);
        int idx = starts.length-1;
        int max = 0;
        int num = 0;
        int[] temp = starts.clone();
        Arrays.sort(temp);
        Map<Integer,Integer> map = new HashMap();
        for(int i=e; i>=temp[0]; i--){
            if(dp[i]>=max){
                max=dp[i];
                num = i;
            }
            if(temp[idx]==i){
                map.put(i,num);
                idx--;
            }
        }
        for(int i=0; i<starts.length; i++){
            answer[i] = map.get(starts[i]);
        }
        return answer;
    }
    public void count(int[] dp, int n){
        for(int i=2; i<=n; i++){
            for(int j=1; j*i<=n; j++){
                dp[i*j]++;
            }
        }
    }
}