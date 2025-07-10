import java.util.*;

class Solution {
    private Map<Integer, Integer> map = new HashMap(); // 시추 번호, 총량
    private int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    private int n,m;
    public int solution(int[][] land) {
      
        // 가장 많이 뽑을 수 있는 시추관 찾기. 250_000
        n = land.length;
        m = land[0].length;
        int num = 1; // 시추 번호
        int[] sumArr = new int[m]; // 시추 뚫었을 때 얻을 수 있는 용량
        Set<Integer>[] set = new Set[m]; // 시추 중복 제거 및 확인용
        for(int i=0; i<m; i++){
            set[i] = new HashSet();
        }
            
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(land[i][j]==1){
                    // 시추하기
                    int total = bfs(i,j,land, ++num);
                    set[j].add(num);
                    sumArr[j] += total;
                }else if(land[i][j]>1){
                    int now = land[i][j]; // 현재 시추 번호
                    // 총량 저장하기
                    if(!set[j].contains(now)){
                        sumArr[j]+= map.get(now);
                        set[j].add(now);
                    }
                }
            }
        }
        
        
        return Arrays.stream(sumArr).max().orElse(0);
    }
    public int bfs(int x, int y, int[][] land, int num){
        Queue<int[]> q = new ArrayDeque();
        q.add(new int[]{x,y});
        land[x][y] = num;
        int total = 1;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i=0; i<4; i++){
                int nx = now[0] + dir[i][0];
                int ny = now[1] + dir[i][1];
                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                if(land[nx][ny]==1){
                    land[nx][ny] = num;
                    total++;
                    q.add(new int[] {nx,ny});
                }
            }
        }
        map.put(num, total);
        return total;
    }
}

