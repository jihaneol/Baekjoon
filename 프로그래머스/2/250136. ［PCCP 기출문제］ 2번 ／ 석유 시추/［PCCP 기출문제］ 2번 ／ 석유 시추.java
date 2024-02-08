import java.util.*;
class Solution {
    public int key;
    public int n,m;
    public Map<Integer,Integer> map;
    public int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public boolean[][] visited;
    
    public int solution(int[][] land) {
        int answer = 0;
        key = 2;
        map = new HashMap();
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        
        for(int i=0; i<m; i++){
            int oil = getOil(i, land);
            answer = Math.max(answer,oil);
        }
       
        return answer;
    }
    
    public int getOil(int start, int[][] land){
        boolean[] visitedKey = new boolean[100000];
        int oilTotal = 0;
        
        for(int r=0; r<n; r++){
            int nowKey = land[r][start];
            if(nowKey!=0){
                if(visitedKey[nowKey]) continue;
                
                if(map.containsKey(nowKey)){
                    oilTotal+=map.get(nowKey);
                    visitedKey[nowKey] = true;
                }else{
                    int oilAmount=bfs(key, r, start, land); //bfs 탐색
                    map.put(key,oilAmount);
                    oilTotal+=oilAmount;
                    visitedKey[key++] = true;
                }
            }
        }
        
        return oilTotal;
    }
    
    public int bfs(int key,int x, int y,int[][] land){
        Deque<int[]> q = new ArrayDeque();
        q.add(new int[] {x,y});
        visited[x][y] = true;
        land[x][y] = key;
        int result = 1;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i=0; i<4; i++){
                int nx = now[0] + dir[i][0];
                int ny = now[1] + dir[i][1];
                
                if(isRange(nx,ny) || visited[nx][ny] || land[nx][ny]==0) continue;
                result++;
                land[nx][ny] = key;
                q.add(new int[]{nx,ny});
                visited[nx][ny] = true;
            }
        }
        return result;
    }
    
    public boolean isRange(int x, int y){
        return x<0 || y<0 || x>=n || y>=m;
    }
}