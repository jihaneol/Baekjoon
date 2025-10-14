import java.util.*;
class Solution {
    private int[][] dp;
    private List<Integer>[] tree;
    public int solution(int[] sales, int[][] links) {
        int answer = 0;
        int n = sales.length;
        
        dp = new int[n+1][2];
        tree = new List[n+1];
        
        for(int i=0; i<=n; i++){
            tree[i] = new ArrayList();
        }
        
        for(int[] link : links){
            tree[link[0]].add(link[1]);
        }
        
        calcuSales(1, sales);

        return Math.min(dp[1][0], dp[1][1]);
    }
    
    private void calcuSales(int curv, int[] sales){
        dp[curv][1] = sales[curv-1];
        boolean noChild = true;
        boolean isLeaf = true;
        
        for(int nextv : tree[curv])
        {
            isLeaf = false;
            calcuSales(nextv, sales);
            
            if(dp[nextv][0] >= dp[nextv][1]) noChild = false;
            
            dp[curv][0] += Math.min(dp[nextv][0], dp[nextv][1]);
            dp[curv][1] += Math.min(dp[nextv][0], dp[nextv][1]);
        }
        
        if(!isLeaf && noChild){
            int sum = Integer.MAX_VALUE;
            
            for(int nextv : tree[curv])
            {
                sum = Math.min(sum, dp[nextv][1] - dp[nextv][0]);
            }
            
            dp[curv][0] += sum;
        }

    }
                                                                                                                                                                 
}