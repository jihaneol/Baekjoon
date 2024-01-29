import java.util.*;

public class Solution {

    
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int now = 0; // 현재시간
        int cnt = 0; //연속 성공 횟수
        int nowHealth = health;
        for(int[] attack : attacks){
            
            int diff = attack[0] - now -1; //시간차이
            cnt = diff/bandage[0]; // 연속 횟수
            
            // 회복
            nowHealth = Math.min(health,cnt*bandage[2] + nowHealth); //추가
            nowHealth = Math.min(health,diff*bandage[1] + nowHealth); //초당 회복
            // 공격 당함
            now = attack[0];
            nowHealth-=attack[1];
            
            if(nowHealth<=0) return -1;
        }
        
        return nowHealth;
    }

}