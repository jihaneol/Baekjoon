import java.util.*;
class Solution {
    private int answer = 0;
    private int[][] global_q;
    private int[] global_ans;
    private int global_n;
    public int solution(int n, int[][] q, int[] ans) {
        
        global_q = q;
        global_ans = ans;
        global_n = n;
        
        combi(1,0,new ArrayList<>());
        
        return answer;
    }
    private void combi(int now, int depth, List<Integer> codes){
        if(depth>=5) {
           
            
            for(int i=0; i<global_ans.length; i++){
                int cnt = 0;
                int[] q = global_q[i];
                
                for(int value : q){
                    if(codes.contains(value)){
                        cnt++;
                    }
                }
                
                if(global_ans[i] != cnt) return;
            }

            answer++;
            return;
        }
        
        for(int i= now; i<=global_n; i++){
            codes.add(i);
            combi(i+1, depth+1, codes);
            codes.remove(codes.size()-1);
        }
    }
    
    
}