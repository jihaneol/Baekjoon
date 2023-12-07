import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int num : nums){
            set.add(num);
        }
        int selectTotal = nums.length/2;
        int poketmonNum = set.size();
        if(selectTotal>poketmonNum) return poketmonNum;
        
        return selectTotal;
    }
}