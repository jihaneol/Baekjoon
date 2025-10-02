import java.util.*;
class Solution {
    class Pos {
        int x, y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private boolean red_arrive, blue_arrive;
    private int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    private int n, m, answer;
    private boolean[][][] visited; // [0] 는 red, [1] 는 blue
    private int red_x, red_y, blue_x, blue_y;
    private int[][] g_maze;
    public int solution(int[][] maze) {
        g_maze = maze;
        answer = 21;
        n = maze.length;
        m = maze[0].length;
        
        visited = new boolean[n][m][2];
        
        Pos red = null;
        Pos blue = null;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(maze[i][j]==1){
                    red = new Pos(i,j);
                }else if(maze[i][j]==2){
                    blue = new Pos(i,j);
                }else if(maze[i][j]==3){
                    red_x = i;
                    red_y = j;
                }else if(maze[i][j]==4){
                    blue_x = i;
                    blue_y = j;
                }
            }
        }
        visited[red.x][red.y][0] = true;
        visited[blue.x][blue.y][1] = true;
        move(red.x, red.y, blue.x, blue.y, 0);
        
        // 어떻게 도착이 풀리는지 알지?
        
        return answer==21?0:answer;
    }
    
    private void move(int rx, int ry, int bx, int by, int round){
      
    
        
        if(blue_arrive && red_arrive){
            answer = Math.min(answer, round);
            return;
        }
        
        for(int i=0; i<4; i++){
            Pos nextRed = red_arrive? new Pos(rx, ry) : new Pos(rx+dir[i][0], ry+dir[i][1]);
            for(int j=0; j<4; j++){
                Pos nextBlue = blue_arrive? new Pos(bx,by) : new Pos(bx+dir[j][0], by+dir[j][1]);
                
                if(!validate(new Pos(rx,ry), new Pos(bx,by), nextRed, nextBlue)) continue;
                
                if(!red_arrive && visited[nextRed.x][nextRed.y][0]) continue;
                if(!blue_arrive && visited[nextBlue.x][nextBlue.y][1]) continue;
                
                if(g_maze[nextRed.x][nextRed.y] == 3) red_arrive = true;
                if(g_maze[nextBlue.x][nextBlue.y] == 4) blue_arrive = true;
                
                
                visited[nextRed.x][nextRed.y][0] = true;
                visited[nextBlue.x][nextBlue.y][1] = true;
                move(nextRed.x, nextRed.y, nextBlue.x, nextBlue.y, round+1);
                visited[nextRed.x][nextRed.y][0] = false;
                visited[nextBlue.x][nextBlue.y][1] = false;  
                
                red_arrive = false;
                blue_arrive = false;
            }
        }
        
       
        
    }
    private boolean validate(Pos preRed, Pos preBlue, Pos red, Pos blue){
        // 벽 또는 격자 밖 안된다.
        if(red.x<0 || red.x>=n || blue.x<0 || blue.x>=n ||
          blue.y<0 || blue.y>=m || red.y<0 || red.y>=m) return false;
        
        if(g_maze[red.x][red.y]==5 || g_maze[blue.x][blue.y]==5) return false;
        
        // 동시에 두 수레를 같은 칸으로 움직 X
        if(red.x==blue.x && red.y==blue.y) return false;
        
        // 수레끼리 자리를 바꾸면 안된다.
        if(preRed.x==blue.x && preRed.y==blue.y && preBlue.x==red.x && preBlue.y==red.y) return false;
        
        return true;
    }
}