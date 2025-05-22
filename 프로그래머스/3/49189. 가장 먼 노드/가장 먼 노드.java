import java.util.*;
class Solution {
    private List<List<Integer>> graph = new ArrayList();
    private boolean[] visited;
    private int answer;
    public int solution(int n, int[][] edge) {
        visited = new boolean[n+1];
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList());
        }
        for(int[] vertex : edge){
            graph.get(vertex[0]).add(vertex[1]);
            graph.get(vertex[1]).add(vertex[0]);
        }
        
        bfs(1);
        
        return answer;
    }
    public void bfs(int start){
        visited[start] = true;
        Queue<Integer> q = new LinkedList();
        q.add(start);
        
        while(!q.isEmpty()){
            
            int size = answer = q.size();
            while(size--!=0){
                int now = q.poll();
                for(int next : graph.get(now)){
                    if(visited[next]) continue;
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}