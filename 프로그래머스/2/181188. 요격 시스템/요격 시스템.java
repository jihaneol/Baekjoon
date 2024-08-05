import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets,(int[] a, int[] b)->{
            return Integer.compare(a[1],b[1]);
        });
        int e = 0;
        for(int[] target : targets){
            int s = target[0];
            if(e<=s){
                e = target[1];
                answer++;
            }
        }
        return answer;
    }
}