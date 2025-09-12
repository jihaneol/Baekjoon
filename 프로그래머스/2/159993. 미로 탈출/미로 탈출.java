import java.util.*;
class Point{
    int x, y, cnt;
    boolean lever_pull;
    
    Point(int x, int y, boolean lever_pull, int cnt){
        this.x = x;
        this.y = y;
        this.lever_pull = lever_pull;
        this.cnt = cnt;
    }
} 

class Solution {
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        int endX = 0;
        int endY = 0;
        int answer = 0;
        // bfs 레버 당기면 새롭게 시작, 
        boolean[][][] visited = new boolean[n][m][2];
        Queue<Point> q = new ArrayDeque();
        end : for(int i=0; i<n; i++){
            String map = maps[i];
            for(int j=0; j<m; j++){
                if('S' ==map.charAt(j)){
                    q.add(new Point(i,j,false,0));
                    visited[i][j][0] = true;
                    break end;
                }
            }
        }
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        while(!q.isEmpty()){
            
            Point now = q.poll();
            
            if(now.lever_pull && maps[now.x].charAt(now.y)=='E'){
                return now.cnt;
            }
            
            for(int[] d : dir){
                int nx = d[0] + now.x;
                int ny = d[1] + now.y;
                int num = now.lever_pull ? 1 : 0;
                
                if(nx<0 || ny<0 || nx>=n || ny>=m || 
                   maps[nx].charAt(ny)=='X') continue;
                if(visited[nx][ny][num]) continue;
                
                visited[nx][ny][num] = true;
                
                if(maps[nx].charAt(ny)=='L'){
                    q.add(new Point(nx, ny, true, now.cnt+1));
                    visited[nx][ny][1] = true;
                }else{
                    q.add(new Point(nx, ny, now.lever_pull, now.cnt+1));
                }
                
                

            }
        }
        
        
        
        return -1;
    }
}