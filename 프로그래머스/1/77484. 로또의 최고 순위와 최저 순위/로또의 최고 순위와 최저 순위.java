class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        // 번호 순위 6,6,5,4,3,2,1
        int[] rank = {6,6,5,4,3,2,1};
        int[] temp = {0,0};
        boolean[] nums = new boolean[46];
        for(int win : win_nums){
            nums[win] = true;
        }
        
        for(int lotto : lottos){
            if(lotto==0){
                temp[0]++;
            }else if(nums[lotto]){
                temp[0]++;
                temp[1]++;
            }
        }
        return new int[] {rank[temp[0]], rank[temp[1]]};
    }
}