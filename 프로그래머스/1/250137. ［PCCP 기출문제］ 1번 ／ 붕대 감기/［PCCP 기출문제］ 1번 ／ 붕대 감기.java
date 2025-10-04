class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
       
        int startTime = 0;
        int totalHealth = health;
        for(int[] attack : attacks){
            int seq = attack[0] - startTime-1;
            
            // 초당 회복, 추가 회복 
            health = (health + (seq/bandage[0])*bandage[2] + seq*bandage[1]) > totalHealth 
                ? totalHealth : (health + (seq/bandage[0])*bandage[2] + seq*bandage[1]);
            
            // 공격
            health -= attack[1];
            
            if(health<=0) return -1;
            
            // 시작 시간 갱신
            startTime = attack[0];
        }
        
        return health;
    }
}