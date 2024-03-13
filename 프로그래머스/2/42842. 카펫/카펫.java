import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // x 세로, y 가로
        int target = (int)Math.sqrt(yellow);
        for(int x=1; x<=target; x++){
            if(yellow%x==0){
                int y = yellow/x;
                if((x+y)*2+4 == brown){
                    answer[0] = y+2;
                    answer[1] = x+2;
                    break;
                }
            }
        }
        return answer;
    }
}