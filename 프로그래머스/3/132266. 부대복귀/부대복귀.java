import java.util.*;

class Solution {
    List<List<Integer>> road = new ArrayList();
    int[] distance;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        distance = new int[n+1];
        for(int i=0; i<=n; i++){
            road.add(new ArrayList());
        }
        
        for(int[] r : roads){
            int s = r[0];
            int e = r[1];
            road.get(s).add(e);
            road.get(e).add(s);
        }
        Arrays.fill(distance,-1);
        distance[destination] = 0;
        bfs(destination);
        
        for(int i=0; i<sources.length; i++){
            answer[i] = distance[sources[i]];
        }
        return answer;
    }
    public void bfs(int start){
        Queue<Integer> q = new LinkedList();
        q.add(start);
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int now = q.poll();
                
                for(int next : road.get(now)){
                    if(distance[next]==-1){
                        distance[next] = distance[now]+1;
                        q.add(next);
                    }
                }
            }
        }
    }
    
}