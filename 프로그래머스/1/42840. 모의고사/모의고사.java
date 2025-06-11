import java.util.*;
class Solution {
    private int[] supo1 = {1,2,3,4,5};
    private int[] supo2 = {2,1,2,3,2,4,2,5};
    private int[] supo3 = {3,3,1,1,2,2,4,4,5,5};
    
    public int[] solution(int[] answers) {
        int[] res = new int[3];
        
        for(int i=0; i<answers.length; i++){
            if(supo1[i%5] == answers[i]){
                res[0]++;
            }
            if(supo2[i%8] == answers[i]){
                res[1]++;
            }
            if(supo3[i%10] == answers[i]){
                res[2]++;
            }
        }
        
        int max = Arrays.stream(res).max().getAsInt();
    
        List<Integer> list = new ArrayList();
        
        for(int i=0; i<res.length; i++){
            if(res[i]==max){
                list.add(i+1);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}