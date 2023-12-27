import java.util.*;
class Solution {
    private static int answer;
    private static List<Integer>[] graph;
    private static boolean[] visited;
    public int solution(int n, int[][] lighthouse) {
        
        answer = 0;
        graph = new List[n+1];
        visited = new boolean[n+1];
        
        for(int i=1; i<n+1; i++){
            graph[i] = new ArrayList();
        }
       
        for(int i=0; i<n-1; i++){
            graph[lighthouse[i][0]].add(lighthouse[i][1]);
            graph[lighthouse[i][1]].add(lighthouse[i][0]);
        }
        
        connect(1);
        
        return answer;
    }
    private static boolean connect(int start){
        
        visited[start] = true;
        // 0 1 판단.
        boolean hasLeaf = false;
        for(int next : graph[start]){
            if(visited[next]) continue;
            if(connect(next)){
                hasLeaf = true;
            }
            
        }
        if(hasLeaf) {
            answer++;
            return false;
        }
        else return true;
    }
 
}