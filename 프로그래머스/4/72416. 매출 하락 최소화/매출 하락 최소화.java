import java.util.*;
class Solution {
    
    private List<List<Integer>> tree = new ArrayList();
    private int[][] dp;
    public int solution(int[] sales, int[][] links) {
        int answer = 0;
        int n = sales.length;
        dp = new int[n+1][2];
        for(int i=0; i<=n; i++){
            tree.add(new ArrayList());
        }
        
        
        for(int i=0; i<n-1; i++){
            int[] link = links[i];
            int s = link[0];
            int e = link[1];
            
            tree.get(s).add(e);
        }
        getWorkShop(1, sales);
        return Math.min(dp[1][0], dp[1][1]);
    }
    private void getWorkShop(int cur, int[] sales){
        
        int cur_sale = sales[cur-1];
        dp[cur][1] = cur_sale;
        
        boolean noChildInclude = true;
        boolean leaf = true;
        
        for(int next : tree.get(cur)){
            leaf = false;
            getWorkShop(next, sales);
            if(dp[next][0] >= dp[next][1]){
                noChildInclude = false;
            }
            dp[cur][1] += Math.min(dp[next][0], dp[next][1]);
            dp[cur][0] += Math.min(dp[next][0], dp[next][1]);
        }
     
        
        
        if(!leaf && noChildInclude){
            int sum = Integer.MAX_VALUE;
            for(int next : tree.get(cur)){
                if(sum > dp[next][1] - dp[next][0]){
                    sum = dp[next][1] - dp[next][0];
                }
            }
            dp[cur][0] += sum;
        }
    }
}