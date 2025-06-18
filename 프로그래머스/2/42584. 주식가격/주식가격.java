import java.util.*;
class Stuck{
    int idx, price;
    Stuck(int i, int p){
        idx = i;
        price = p;
    }
}
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Stuck> stack = new Stack();
        
        for(int i=0; i<prices.length; i++){
            int price = prices[i];
                
            while(!stack.isEmpty() && stack.peek().price>price){
                Stuck pre = stack.pop();
                answer[pre.idx] = i-pre.idx;
            }
            stack.push(new Stuck(i, price));
        }
        
        // 나머지
        while(!stack.isEmpty()){
            Stuck now = stack.pop();
            answer[now.idx] = prices.length - now.idx-1;
        }
        return answer;
    }
}