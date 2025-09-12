import java.util.*;
class Solution {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int INF = 10001;
        int[][] dp = new int[n+1][k]; // [정점, 시간];
        for(int[] arr : dp){
            Arrays.fill(arr,INF);
        }
        dp[gps_log[0]][0] = 0;
        List<Integer>[] graph = new List[n+1];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList();
            // graph[i].add(i);
        }
        
        for(int[] edge : edge_list){
            int s = edge[0];
            int e = edge[1];
            graph[s].add(e);
            graph[e].add(s);
        }
        
        for(int t=1; t<k; t++){
            for(int pre=1; pre<=n; pre++){ // 정점 순회
                int preV = dp[pre][t-1];
                int goalNode = gps_log[t];
                
                for(int next : graph[pre]){
                    if(goalNode==next){
                        dp[next][t] = Math.min(dp[next][t], preV);
                    }else{
                        dp[next][t] = Math.min(dp[next][t], preV+1);
                    }
                }
            }
        }

    
        
        return dp[gps_log[k-1]][k-1]==INF ? -1 : dp[gps_log[k-1]][k-1];
    }
}