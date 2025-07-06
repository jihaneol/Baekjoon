import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int i = 0;
        int j = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        // 1,3,5,7  2,2,6,8
        while(j<B.length){
            if(A[i]<B[j]){
                answer++;
                i++;
                j++;
            }else if(A[i]>=B[j]){
                j++;
            }
        }
         
        return answer;
    }
}