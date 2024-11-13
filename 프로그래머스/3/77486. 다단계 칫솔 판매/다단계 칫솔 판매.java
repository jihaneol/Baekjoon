import java.util.*;
class Solution {
    
    private Map<String,List<String>> graphMap = new HashMap();
    private Map<String, Integer> sellerMap = new HashMap();
    private Map<String, Integer> enrollIdx = new HashMap();
    private int[] answer;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        answer = new int[enroll.length];
        //1만
        for(int i=0; i<enroll.length; i++){
            String name = enroll[i];
            String ref = referral[i];
            enrollIdx.put(name,i);
            // 그래프 없다면
            if(!graphMap.containsKey(name)){
                graphMap.put(name, new ArrayList());
            }
            
            if(!"-".equals(ref)){
                graphMap.get(name).add(ref);
            }
        }
        //10만
        for(int i=0; i<seller.length; i++){
            String name = seller[i];
            int cnt = amount[i];
            distributeAmount(name, cnt*100);
        }
        
        return answer;
    }
    private void distributeAmount(String name, int money){
        
        int nowIdx = enrollIdx.get(name);
        
        int percentMoney = (int)(money*0.1);
        answer[nowIdx] += (money-percentMoney);
        if(percentMoney==0) return;
        for(String ref : graphMap.get(name)){
            distributeAmount(ref, percentMoney);
        }
        
    }
}