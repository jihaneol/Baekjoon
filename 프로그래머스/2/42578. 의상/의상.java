import java.util.*;
class Solution {
    private Map<String, Integer> map = new HashMap();
    public int solution(String[][] clothes) {
        // 1,2 -> 5개 | 3 -> 3개
        
        for(String[] clothe : clothes){
            map.put(clothe[1], map.getOrDefault(clothe[1],0)+1);
        }
        
        int[] arr = map.values().stream().mapToInt(Integer::intValue).toArray();
        int answer = 1;
        for(int i : arr){
            answer*=i+1;
        }
        return answer-1;
    }   
}