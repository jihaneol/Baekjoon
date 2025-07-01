import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] nums) {
        // n/2 만큼 가져가고 최대로 가질수있는 개수
        int max = nums.length/2;
        Set<Integer> set = 
            Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        
        
        return max <set.size()?max : set.size();
    }
}