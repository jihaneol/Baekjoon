import java.util.*;
class Solution {
    private int[] topology;
    private boolean[] visited;
    private long answer;
    private List<List<Integer>> tree= new ArrayList();
    
    public long solution(int[] a, int[][] edges) {
        boolean isZero = true;
        long sum = 0;
        int len = a.length;
        topology = new int[len];
        visited = new boolean[len];
        long[] b = new long[a.length];
        for(int i=0; i<len; i++){
            tree.add(new ArrayList());
            b[i] = a[i];
        }
        
        for(int i=0; i<len-1; i++){
            if(a[i]!=0) isZero = false;
            sum+=a[i];
            int s = edges[i][0];
            int e = edges[i][1];
            topology[s]++;
            topology[e]++;
            tree.get(s).add(e);
            tree.get(e).add(s);
        }
        
        sum+=a[len-1];
        if(isZero && a[len-1]==0) return 0;
        
        if(sum!=0) return -1;
        Queue<Integer> q = new ArrayDeque();
        for(int i=0; i<len; i++){
            if(topology[i]==1){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int now = q.poll();
            visited[now] = true;
        
            for(int next :tree.get(now)){
                if(visited[next]) continue;
                b[next] += b[now];
                answer+= Math.abs(b[now]);
                topology[now]--;
                topology[next]--;
                if(topology[next]==1) q.add(next);
            }
        }
        
        return answer;
    }
}