import java.util.*;

public class Solution {

    
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int now = 0; // 현재시간
        int contiAttack = 0;
        int nowHealth = health;
        for(int[] attack : attacks){
            for(int i=now+1; i<attack[0]; i++){
                if(++contiAttack == bandage[0]){
                    contiAttack = 0;
                    nowHealth+=bandage[2];
                }
                nowHealth+=bandage[1];
                if(nowHealth>health) nowHealth=health;
            }
            contiAttack = 0;
            now = attack[0];
            
            nowHealth-=attack[1];
            
            if(nowHealth<=0) return -1;
            
        }
        
        return nowHealth;
    }

}