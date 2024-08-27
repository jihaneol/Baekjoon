import java.util.*;
class Solution {
    int[] node;
    ArrayList<Integer>[] graph = new ArrayList[17];
    boolean[][][] visited;
    int max = 0;
    public int solution(int[] info, int[][] edges) {
       node = info;
        for(int i=0; i<node.length; i++){
            graph[i] = new ArrayList();
        }
        for(int[] edge  : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        visited = new boolean[17][18][18];
        dfs(0,0,0);
        return max;
    }

    public void dfs(int idx, int s, int w) {
      if(visited[idx][s][w]) return;
        visited[idx][s][w] = true;
        int backS = s;
        int backW = w;
        int backNode = node[idx];
        if(node[idx]==0)
            s++;
        else if(node[idx]==1) 
            w++;
        node[idx] =  -1;

        if(s>w){
            max = Math.max(max,s);
            
            for(int next : graph[idx]){
                dfs(next,s,w);
            }
        }
            
         node[idx] =  backNode;
         visited[idx][backS][backW] = false;
        
    }
}
