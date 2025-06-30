import java.util.*;
class Solution {
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> nodeMap = new HashMap();
        Map<String, Integer> amountMap = new HashMap();
        List<Integer> answer = new ArrayList();
        
        for(int i=0; i<enroll.length; i++){
            String child = enroll[i];
            String perent = referral[i];
            amountMap.put(child, 0);
            nodeMap.put(child, perent);
        }
        
        for(int i=0; i<seller.length; i++){
            int revenue = amount[i]*100;
            
            for(String child = seller[i]; !child.equals("-") && revenue>0; 
                child=nodeMap.get(child))
            {
                int pay = revenue/10;
                amountMap.put(child, amountMap.get(child)+revenue-pay);
                revenue = pay;
            }
        }
        
        for(String e : enroll){
            answer.add(amountMap.get(e));
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}