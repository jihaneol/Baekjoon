import java.util.*;
class Solution {
    private int answer, n;
    private Integer[] dp;
    private int MAX = 10111111;
    private Set<String> set = new HashSet();
    public int solution(String[] strs, String t) {
        n = t.length();
        dp = new Integer[n];
        for(String s : strs){
            set.add(s);
        }
        dfs(t, 0);

        return dp[0]==MAX? -1 : dp[0];
    }
    private int dfs(String t, int s){
        if(n==s) return 0;
        
        if(dp[s]!=null){
            return dp[s];
        }
        dp[s] = MAX;
        
        for(int e=s+1; e<=n && e<=s+5; e++){
           
            String sub = t.substring(s,e);
            
            if(set.contains(sub)){
                dp[s] = Math.min(dfs(t,e)+1,dp[s]);
            }
        }
        
        return dp[s];
    }
}