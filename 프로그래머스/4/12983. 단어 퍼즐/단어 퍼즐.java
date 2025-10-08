import java.util.*;
class Solution {
    public int solution(String[] strs, String t) {
        Set<String> strSet = new HashSet();
        for(String str : strs){
            strSet.add(str);
        }
        
        int n = t.length();
        int[] dp = new int[n+1];
        
        Arrays.fill(dp,10000000);
        dp[0] = 0;
        
        for(int i=0; i<n; i++){
            for(int j=1; j<=5 && j+i<=n; j++){
                String sub = t.substring(i,i+j);
                if(strSet.contains(sub)){
                // System.out.println(sub);
                    dp[i+j] = Math.min(dp[i+j], dp[i] + 1);
                }
            }
        }
        
        
        return dp[n]==10000000?-1:dp[n];
    }
}