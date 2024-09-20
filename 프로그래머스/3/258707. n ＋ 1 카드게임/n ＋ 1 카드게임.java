import java.util.*;

class Solution {
    Set<Integer> original, additional;
    int n;
    public int solution(int coin, int[] cards) {
        original = new HashSet();
        additional = new HashSet();
        n = cards.length;
        for(int i=0; i<n/3; i++){
            original.add(cards[i]);
        }
        
        
        int x = n/3; // 뽑은 카드 수
        int target = n+1;
        return play(1,x, coin, cards);
    
    }
    public int play(int round,int idx ,int coin, int[]cards){
        
        if(idx==n){
            return round;
        }
        
        int a = cards[idx];
        int b = cards[idx+1];
        additional.add(a);
        additional.add(b);
        boolean isSolve = false;
        
        //기존으로 해결 가능한가?
        for(int card : original){
            if(original.contains(n-card+1)){
                original.remove(n-card+1);
                original.remove(card);
                isSolve = true;
                break;
            }
        }
        
        // 코인 하나 써야 한다. 오리지날과 추가한 부분 확인
        if(!isSolve && coin>0){
            for(int card : original){
                if(additional.contains(n-card+1)){
                    original.remove(card);
                    additional.remove(n-card+1);
                    coin--;
                    isSolve = true;
                    break;
                }
            }
        }
        
        // 코인 두개 쓰고. 추가한 부분들만 보자
        if(!isSolve && coin>1){
            for(int card : additional){
                if(additional.contains(n-card+1)){
                    additional.remove(card);
                    additional.remove(n-card+1);
                    coin-=2;
                    isSolve = true;
                    break;
                }
            }
        }
        
        if(isSolve) {
            return play(round+1,idx+2,coin, cards);
        }
        
        return round;
        
    }
}