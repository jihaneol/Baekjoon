import java.util.*;

class Solution {
    
    List<List<Integer>> graph;
    int[] in;
    int[] out;
    int[] answer;
    boolean[] visited;
    public int[] solution(int[][] edges) {
        answer = new int[4];
        in= new int[1000001];
        out = new int[1000001];
        visited = new boolean[1000001];
        graph = new ArrayList();
        for(int i=0; i<1000001; i++){
            graph.add(new ArrayList());
        }
        
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            out[edge[0]]++;
            in[edge[1]]++;
        }
        
        for(int i=1; i<1000001; i++){
            if(in[i]==0 && out[i]>=2) {
                answer[0] = i;
                break;
            }
        }
        dfs(answer[0]);
        return answer;
    }
    
    public void dfs(int start){
       
        for(int next :graph.get(start)){
            in[next]--;
            answer[check(next)]++; // 8자 인지 도넛인지 판별
            
        }
    }
    public int check(int start){
        visited[start] = true;
        if(in[start] == 2 && out[start] ==2){
                return 3;
        }
        if(out[start]==0) return 2;
        for(int next :graph.get(start)){
            if(visited[next]) continue;
            return check(next);
        }
        
        return 1;
    }
}