class Solution {
    class Pos{
        int x, y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    private int[][] maze;
    private int n,m,answer;
    private boolean[][][] visited;
    private boolean isRedEnd, isBlueEnd;
    private int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public int solution(int[][] maze) {
        this.maze = maze;
        
        answer = 21;
        n = maze.length;
        m = maze[0].length;
        
        Pos red = null;
        Pos blue = null;
        visited = new boolean[n][m][2];
        
        for(int i=0; i<maze.length; i++){
            for(int j=0; j<maze[0].length; j++){
                if(maze[i][j]==1){
                    visited[i][j][0] = true;
                    red = new Pos(i,j);
                }else if(maze[i][j]==2){
                    visited[i][j][1] = true;
                    blue = new Pos(i,j);
                }
            }
        }
        
        move(red, blue,0);
        
        return answer==21?0:answer;
    }
    
    private void move(Pos red, Pos blue, int depth)
    {
        if(isRedEnd && isBlueEnd){
        
            answer = Math.min(answer, depth);
            return;
        }
        
        for(int i=0; i<4; i++)
        {
            Pos nextR = isRedEnd? red : new Pos(dir[i][0]+red.x, red.y + dir[i][1]);
            for(int j=0; j<4; j++)
            {
                Pos nextB = isBlueEnd? blue : new Pos(dir[j][0]+blue.x, blue.y + dir[j][1]);
                
                if(!validate(red, blue, nextR, nextB)) continue;
                
                
                visited[nextR.x][nextR.y][0] = true;
                visited[nextB.x][nextB.y][1] = true;
                
                if(maze[nextR.x][nextR.y]==3) isRedEnd = true;
                if(maze[nextB.x][nextB.y]==4) isBlueEnd = true;
                
                move(nextR, nextB, depth+1);
                
                if(maze[nextR.x][nextR.y]==3) isRedEnd = false;
                if(maze[nextB.x][nextB.y]==4) isBlueEnd = false;
                visited[nextR.x][nextR.y][0] = false;
                visited[nextB.x][nextB.y][1] = false;
            }
        }
        
    }
    
    private boolean validate(Pos prer, Pos preb, Pos r, Pos b)
    {
        // 1. 벽, 격자
        if(r.x<0 || r.y<0 || b.x<0 || b.y<0 ||
          r.x>=n || r.y>=m || b.x>=n || b.y>=m || 
           maze[r.x][r.y] == 5 || maze[b.x][b.y]==5) return false;
        
        // 2. 방문 칸
        if(!isRedEnd && visited[r.x][r.y][0]) return false;
        if(!isBlueEnd && visited[b.x][b.y][1]) return false;
                
        // 3. 동시 같은 칸
        if(r.x==b.x && r.y==b.y) return false;
        // 4. 자리 바꿈
        if(r.x==preb.x && r.y==preb.y&& b.x==prer.x && b.y == prer.y) return false;

        return true;
    }
}