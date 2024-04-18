import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] score = new int[3];
        int[][] answer_check_list = {{1,2,3,4,5},
                                {2, 1, 2, 3, 2, 4, 2, 5},
                                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
                               };
        int max = 0;
        for(int i=0; i<3; i++){
            int total = 0;
            int[] checker = answer_check_list[i];
            for(int j=0, c=0; j<answers.length; j++, c%=checker.length){
                if(answers[j]==checker[c++]){
                    total++;
                }
            }
            score[i] = total;
            max = Math.max(max,total);
        }
        
        List<Integer> answer = new ArrayList();
        for(int i=0; i<3; i++){
            if(score[i]==max){
                answer.add(i+1);
            }
        }
        return answer.stream().mapToInt(i->i.intValue()).toArray();
    }
}