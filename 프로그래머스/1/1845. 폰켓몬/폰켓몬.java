import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet();
        for(int num : nums){
            set.add(num);
        }
        int selectTotal = nums.length/2;
        int poketmonNum = set.size();
        if(selectTotal>poketmonNum) answer = poketmonNum;
        else answer = selectTotal;
        return answer;
    }
}