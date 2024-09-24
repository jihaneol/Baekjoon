import java.util.*;

// 근무 태도, 동료 평가 - 모두 낮으면 인센 못받아. 합으로 석차

class Solution {
    public int solution(int[][] scores) {
        int[] s = scores[0];
        Arrays.sort(scores, (s1, s2) -> s1[0] == s2[0] ? s1[1] - s2[1] : s2[0] - s1[0]);
  
        int max = 0, ans = 1;
        for(int[] score : scores) {   
            // 둘다 작다.
            if(score[1] < max && score.equals(s)) {
                return -1;
            }
            if(score[1] < max) continue;
            
            // 비교 대상
            max = Math.max(max, score[1]);
            if(s[0] + s[1] < score[0] + score[1])
                ans++;
        }
        return ans;
    }
}
