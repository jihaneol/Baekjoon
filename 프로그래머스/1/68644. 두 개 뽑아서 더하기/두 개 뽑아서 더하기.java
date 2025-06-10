import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        List<Integer> list = new ArrayList();
        int n = numbers.length;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                list.add(numbers[i]+numbers[j]);
            }
        }
        
        answer = list.stream().distinct().sorted().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}