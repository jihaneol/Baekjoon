import java.util.*;

class Solution {
    Set<Integer> original, additional;
    public int solution(int coin, int[] cards) {
        original = new HashSet();
        additional = new HashSet();
        int n = cards.length;
        for(int i=0; i<n/3; i++){
            original.add(cards[i]);
        }
        int round = 0;
        
        int x = n/3;
        int target = n+1;
        while(true){
            boolean isEnd = false;
            round++;
            if(x>=n) break;
            int A = cards[x];
            int B = cards[x+1];
            additional.add(A);
            additional.add(B);
            x+=2;
            // 내가 갖고 있는 것 비교
            for(int card  : original){
                if(original.contains(target-card)){
                    original.remove(card);
                    original.remove(target-card);
                    isEnd = true;
                    break;
                }
            }
            // 1장 뽑아서 비교
            if(!isEnd && coin>0){
                for(int card : additional){
                    if(original.contains(target-card)){
                        original.remove(target-card);
                        additional.remove(card);
                        --coin;
                        isEnd = true;
                        break;
                    }
                }
            }
            
            // 2장 뽑아서 비교
            if(!isEnd && coin>1){
                for(int card : additional){
                    if(additional.contains(target-card)){
                        additional.remove(target-card);
                        additional.remove(card);
                        coin-=2;
                        isEnd = true;
                        break;
                    }
                }
            }
            // 없으면 나가기
            if(!isEnd){
                break;
            }
        }
        return round;
        
    }
}