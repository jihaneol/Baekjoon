import java.util.*;
class Solution {
    List<List<Integer>> tree = new ArrayList();
    boolean[] visited;
    int[][] dp;
    public int solution(int n, int[][] lighthouse) {
        visited = new boolean[n+1];
        dp = new int[n+1][2];
        for(int i=0; i<=n; i++){
            tree.add(new ArrayList());
        }
        for(int[] light : lighthouse){
            int s = light[0];
            int e = light[1];
            tree.get(s).add(e);
            tree.get(e).add(s);
        }
       
        visited[1] = true;
        return findMinimumRightCnt(1);
    }
    public int findMinimumRightCnt(int start){
        dp[start][1] = 1;
        visited[start] = true;
        for(int next : tree.get(start)){
            if(!visited[next]){
                dp[start][1]+=findMinimumRightCnt(next);
                dp[start][0] += dp[next][1];
            }
        }
        return Math.min(dp[start][0], dp[start][1]); 
    }
   
 
}