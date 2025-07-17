import java.util.*;
class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        List<Set<Integer>> dp = new ArrayList();
        for(int i=0; i<=8; i++){
            dp.add(new HashSet());
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=8; i++){
            sb.append(N);
            dp.get(i).add(Integer.parseInt(sb.toString()));   
        }
        
        for(int k=1; k<=8; k++){
            for(int i=1; i<k; i++){
                for(int a : dp.get(i)){
                    for(int b : dp.get(k-i)){
                        // +
                        dp.get(k).add(a+b);
                        // -
                        dp.get(k).add(a-b);
                        dp.get(k).add(b-a);
                        // *
                        dp.get(k).add(a*b);
                        // 나누기
                        if(a!=0)
                            dp.get(k).add(b/a);
                        if(b!=0)
                            dp.get(k).add(a/b);
                    }
                }
            }
              
            for(int num : dp.get(k)){
                if(num==number){
                    return k;
                }
            }
        }
        
        return -1;
    }
}