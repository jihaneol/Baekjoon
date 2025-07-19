import java.util.*;
class Info{
        int sheep, wolf, node;
        Set<Integer> set; // 이동할 경로
        Info(int node, int s, int w, Set<Integer> set){
            this.node = node;
            this.sheep = s;
            this.wolf = w;
            this.set = set;
        }
    }
class Solution {
    private List<List<Integer>> tree = new ArrayList();
    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        
        for(int i=0; i<n; i++){
            tree.add(new ArrayList());
        }
        for(int[] edge : edges){
            tree.get(edge[0]).add(edge[1]);
        }
        
        Queue<Info> q = new ArrayDeque();
        q.add(new Info(0,0,0,new HashSet()));
        int maxSheep = 0;
        
        while(!q.isEmpty()){
            Info now = q.poll();
            
            if(info[now.node]==0){
                now.sheep++;
                if(maxSheep<now.sheep){
                    maxSheep = now.sheep;
                }
            }else{
                now.wolf++;
            }
            
            if(now.sheep <= now.wolf){
                continue;
            }
            
            // 경로 갱신
            for(int next : tree.get(now.node)){
                now.set.add(next);
            }
            
            // q에 넣기
            for(Integer next : now.set){
                Set<Integer> route = new HashSet();
                
                route.addAll(now.set);
                route.remove(next);
                
                q.add(new Info(next, now.sheep, now.wolf, route));
            }
        }
      
        return maxSheep;
    }
}