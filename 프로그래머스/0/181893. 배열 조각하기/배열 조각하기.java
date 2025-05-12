import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] query) {
        int[] answer = {};
     
        int s = 0;
        int e = arr.length;
        for(int idx = 0; idx<query.length; idx++){
            int q = query[idx];
            
            if(idx%2==0){
              e= s+q;
            }else{
                s = s + q;
            }
        }
        
        // 홀수 인덱스는 앞부분
        // 짝수 인덱스는 뒷부분
        return Arrays.copyOfRange(arr, s, e+1);
    }
}