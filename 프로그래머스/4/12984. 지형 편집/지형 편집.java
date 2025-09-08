import java.util.*;
public class Solution {
    public long solution(int[][] land, int P, int Q) {
        long answer = Long.MAX_VALUE;
        Set<Integer> set = new HashSet();
        int n = land.length;
        int m = land[0].length;
        int len = n*m;
        long right = 0;
        long left = 0;
        int[] height = new int[len];
        for(int i=0; i<n;  i++){
            for(int j=0; j<m; j++){
                height[i*n+j] = land[i][j];
                right +=land[i][j];
            }
        }
        
        Arrays.sort(height);
        long preH = 0;
        // 이전 높이 필요..
        for(int i=0; i<len; i++){
            int h = height[i];
            if(set.contains(h)) continue;
            set.add(h);
            
            left  += i*(h-preH);
            right -= (len-i)*(h-preH);
            
       
            answer = Math.min(answer, left*P + right*Q);
            preH = h;
        }
        
        
    
        return answer;
    }
}