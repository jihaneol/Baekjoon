import java.util.*;
class Solution {
    int max = 0;
    int n,answer;
    int[] copyinfo;
    boolean[][] visited;
    List<List<Integer>> tree = new ArrayList();
    public int solution(int[] info, int[][] edges) {
        n = info.length;
        copyinfo = info;
        answer = 0;
        visited = new boolean[2<<n][n];
        for(int i=0; i<n; i++){
            tree.add(new ArrayList());
        }
        for(int[] edge : edges){
            int s  = edge[0];
            int e  = edge[1];
            tree.get(s).add(e);
            tree.get(e).add(s);
        }
        find(0,0,0,0);
        return answer;
    }
    private void find(int key , int scnt, int wcnt, int now){
      
        if(visited[key][now]) return;
        visited[key][now] = true;
        // key check
        if((key & (1<<now)) == 0){
            if(copyinfo[now]==0){
                scnt++;
                answer = Math.max(answer, scnt);
            }else{
                wcnt++;
            }
            key = key | 1<<now;
        }
        if(scnt <=wcnt) return;
        for(int next : tree.get(now)){
            find(key,scnt,wcnt,next);
        }
    }
}
