import java.util.*;

class Solution {
    private int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    private boolean[][] visited;
    private Map<Integer, Integer> map = new HashMap();
    private int n, m;
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        int no = 1; // 석유번호

        
        // 석유 표시 땅
        // 석유량 표시한 map
        // 파면서 확인하자.
        
        for(int j=0; j<m; j++){
            int total = 0; // 석유량
            Set<Integer> set = new HashSet(); // 팠던 석유인지 확인용
            for(int i=0; i<n; i++){
                int oilNo = land[i][j];
                if(oilNo!=0){
                    
                    // 측정한 석유가 없다면 측정하기.
                    if(!map.containsKey(oilNo)){
                        bfs(i,j,++no,land);
                    }
                    
                    oilNo = land[i][j];
                    
                    // 이미 포함한 석유인지 확인
                    if(set.contains(oilNo)) continue;
                    
                    set.add(oilNo);
                    total += map.get(oilNo);
                    
                }
            }
            answer = Math.max(total, answer);
        }
        
        
        
        return answer;
    }
    private void bfs(int x, int y, int no, int[][] land){
        Queue<int[]> q = new ArrayDeque();
        int total = 1;
        q.add(new int[]{x,y});
        land[x][y] = no;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            for(int[] d : dir){
                int nx = now[0] + d[0];
                int ny = now[1] + d[1];
                
                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                
                if(land[nx][ny]!=1) continue;
                
                q.add(new int[]{nx, ny});
                land[nx][ny] = no;
                total++;
            }
        }
        
        map.put(no, total);
    }
}