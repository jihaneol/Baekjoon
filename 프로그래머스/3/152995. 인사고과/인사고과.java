import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 1;

        for(int i=1;i<scores.length;i++){
            if(scores[i][0]>scores[0][0] && scores[i][1]>scores[0][1]){
                return -1;
            }
            
            if(scores[i][0]+scores[i][1]>scores[0][0] + scores[0][1]){
                if(check(scores[i], scores)){
                    answer++;
                }
            }
        }

        return answer;
    }

    public boolean check(int[] arr, int[][] scores){
        for(int i=0;i<scores.length;i++){
            if(arr[0]<scores[i][0] && arr[1]<scores[i][1]){
                return false;
            }
        }
        return true;
    }
}