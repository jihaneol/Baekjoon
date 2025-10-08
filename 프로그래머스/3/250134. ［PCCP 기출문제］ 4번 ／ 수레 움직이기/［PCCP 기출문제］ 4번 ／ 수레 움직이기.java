class Solution {
    class Pos{
        int x, y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    private boolean[][][] visited;
    private int n, m;
    private int[][] maze;
    private boolean isRedEnd, isBlueEnd;
    public int solution(int[][] maze) {

        n = maze.length;
        m = maze[0].length;
        visited = new boolean[n][m][2];
        this.maze = maze;
        Pos red = null;
        Pos blue = null;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(maze[i][j]==1){
                    red = new Pos(i,j);
                    visited[i][j][0] = true;
                }else if(maze[i][j]==2){
                    blue = new Pos(i,j);
                    visited[i][j][1] = true;
                }
            }
        }
        int answer = dfs(red,blue,0);
        return answer==21? 0:answer;
    }
    private int dfs(Pos red, Pos blue, int depth){
        
        if(isRedEnd && isBlueEnd){
            return depth;
        }
        
        int result = 21;
        
        for(int i=0; i<4; i++){
            Pos nextRed = isRedEnd? red : new Pos(red.x+dir[i][0], red.y+dir[i][1]);
            for(int j=0; j<4; j++){
                Pos nextBlue = isBlueEnd
                    ? blue : new Pos(blue.x+dir[j][0], blue.y+dir[j][1]);
                
                if(!validate(red, blue, nextRed, nextBlue)) continue;
                
                if(maze[nextRed.x][nextRed.y]==3) isRedEnd = true;
                if(maze[nextBlue.x][nextBlue.y]==4) isBlueEnd = true;
                
                visited[nextRed.x][nextRed.y][0] = true;
                visited[nextBlue.x][nextBlue.y][1] = true;
                
                result = Math.min(result,dfs(nextRed, nextBlue, depth+1));
                    
                isRedEnd = false;
                isBlueEnd = false;
                
                visited[nextRed.x][nextRed.y][0] = false;
                visited[nextBlue.x][nextBlue.y][1] = false;
            }
        }
        
        return result;
    }
    private boolean validate(Pos red, Pos blue, Pos nRed, Pos nBlue){
        
        if(nRed.x<0 || nRed.y<0 || nBlue.x<0 || nBlue.y<0 ||
          nRed.x>=n || nRed.y>=m || nBlue.x>=n || nBlue.y>=m) return false;
        
        
        if(maze[nRed.x][nRed.y]==5 || maze[nBlue.x][nBlue.y]==5) return false;
        
        if(!isRedEnd && visited[nRed.x][nRed.y][0]) return false;
        if(!isBlueEnd && visited[nBlue.x][nBlue.y][1]) return false;
        
        if(nRed.x==nBlue.x && nRed.y==nBlue.y) return false;
        
        if(nRed.x==blue.x && nRed.y==blue.y &&
          nBlue.x==red.x && nBlue.y==red.y) return false;
        
        return true;
    }
}