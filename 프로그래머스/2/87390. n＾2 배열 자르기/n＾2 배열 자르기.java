import java.util.*;
class Solution {
    public int[][] map;
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)right-(int)left+1];
       
        for(int i=0; i<right-left+1; i++){
            int r = (int)((left+i)/n);
            int c = (int)((left+i)%n);
            answer[i] = r>c? r+1:c+1;
        }
        
        return answer;
    }
}