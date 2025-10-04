import java.util.*;
class Solution {
    private Map<Integer, Integer> edgeMap = new HashMap();
    private Map<Integer, List<Integer>> treeMap = new HashMap();
    private Set<Integer> visited = new HashSet();
    
    public int[] solution(int[] nodes, int[][] edges) {
        int[] answer = new int[2];
        
        for(int n : nodes){
            treeMap.put(n, new ArrayList());
            edgeMap.put(n, 0);
        }
        
        for(int[] edge : edges){
            int s = edge[0];
            int e = edge[1];
            edgeMap.put(s, edgeMap.get(s)+1);
            edgeMap.put(e, edgeMap.get(e)+1);
            treeMap.get(s).add(e);
            treeMap.get(e).add(s);
        }
        
        for(int n : nodes){
            if(visited.contains(n)) continue;
            visited.add(n);
            checkedTree(n, answer); 
        }
        
        return answer;
    }
    private void checkedTree(int start, int[] answer){
        
        int[] target = new int[2];
        
        Queue<Integer> q = new ArrayDeque();
        
        q.add(start);
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            // 현재 연결수 확인하기.
            int edge = edgeMap.get(now);
            
            int type = Math.abs(now-edge)%2==0?0:1; // 짝홀:0, 역짝홀:1;
            target[type]++;
            
            for(int next : treeMap.get(now)){
                if(visited.contains(next)) continue;
                visited.add(next);
                q.add(next);
            }
        }
        
        if(target[0]==1) answer[0]++;
        if(target[1]==1) answer[1]++;
        
    }

}