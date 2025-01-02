import java.util.*;
class Solution {
    private List<List<Integer>> graph = new ArrayList();
    private int[][] m;
    private boolean[] cycle;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList());
        }
        m = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                m[i][j] = 100_000_000;
            }
        }
        cycle = new boolean[n+1];
        for(int[] fare : fares){
            int c = fare[0];
            int d = fare[1];
            int f = fare[2];
            graph.get(c).add(d);
            graph.get(d).add(c);
            m[c][d] = f;
            m[d][c] = f;
        }
        
        createRoute(s);
        
        warshall(n);
        
        int answer = 100000000;
        for(int i=1; i<=n; i++){
            if(cycle[i]){
              
                answer = Math.min(answer, m[a][i]+m[i][b]+m[i][s]);
            }
        }
  
        return answer;
    }
    
    private void warshall(int n){
        for(int k=1; k<=n; k++){
            if(!cycle[k]) continue;
            m[k][k] = 0;
            for(int i=1; i<=n; i++){
                 if(!cycle[i]) continue;
                for(int j=1; j<=n; j++){
                     if(!cycle[j]) continue;
                    m[i][j] = Math.min(m[i][j], m[i][k]+m[k][j]);
                }
            }
        }
    }
    
    private void createRoute(int s){
        cycle[s] = true;
        for(int next : graph.get(s)){
            if(!cycle[next]){
                createRoute(next);
            }
        }
    }
}