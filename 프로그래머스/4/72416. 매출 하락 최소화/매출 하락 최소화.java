import java.util.*;
class Solution {
    private List<Integer>[] tree;
    private int[][] dp;
    public int solution(int[] sales, int[][] links) {
        int n = sales.length;
        tree = new List[n+1];
        dp = new int[n+1][2];
        for(int i=1; i<=n; i++){
            tree[i] = new ArrayList();
        }
        
        for(int[] link : links){
            tree[link[0]].add(link[1]);
        }
        dfs(sales, 1);
        
        return Math.min(dp[1][0],dp[1][1]);
    }
    private void dfs(int[] sales, int start){
        boolean isLeaf = true;
        boolean noChild = true;
        dp[start][1] = sales[start-1];
        
        for(int next : tree[start]){
            isLeaf = false;
            dfs(sales, next);
            
            // 팀원을 하나라도 선택했다면
            if(dp[next][1]<=dp[next][0]){
                noChild = false;
            }
            
            dp[start][0] += Math.min(dp[next][0], dp[next][1]); 
            dp[start][1] += Math.min(dp[next][0], dp[next][1]); // 팀장을 선택하니까. 자식의 부하들의 최소값을 더한다.
        }
        
        if(!isLeaf && noChild){
            int min = Integer.MAX_VALUE;
            for(int next : tree[start]){
                if(min>dp[next][1] - dp[next][0]){
                    min = dp[next][1] - dp[next][0];
                }
            }
            dp[start][0] += min;
        }
      
    }
}