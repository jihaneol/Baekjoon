class Solution {
    private boolean[][][] visited; // 빨간, 파랑 수레 이동 체크
    private int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    private int n, m, answer;
    private Position red_end, blue_end;
    private class Position{
        int x, y;
        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
        public boolean equals(Position p){
            return x==p.x && y==p.y;
        }
    }
    
    public int solution(int[][] maze) {
        n = maze.length;
        m = maze[0].length;
        answer = 16;
        visited = new boolean[2][n][m];
        Position red = null;
        Position blue = null;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                switch(maze[i][j]){
                    case 1:
                        red = new Position(i, j);
                        visited[0][i][j] = true;
                        break;
                    case 2:
                        blue = new Position(i,j);
                        visited[1][i][j] = true;
                        break;
                    case 3:
                        red_end = new Position(i, j);
                        break;
                    case 4:
                        blue_end = new Position(i,j);
                }     
            }
        }
        backTracking(red, blue, 0, maze);
            
        return answer==16 ? 0 : answer;
    }
    public void backTracking(Position red, Position blue, 
                             int total ,int[][] maze)
    {

        if(red.equals(red_end) && blue.equals(blue_end)){
            if(total < answer){
                answer = total;
            }
            return;
        }
    

        // 완탐
        for(int i=0; i<4; i++){
                Position nextRed = red.equals(red_end) ? 
                    red : new Position(red.x+dir[i][0], red.y+dir[i][1]);
          
            for(int j=0; j<4; j++){
                Position nextBlue = blue.equals(blue_end) ? 
                    blue : new Position(blue.x+dir[j][0], blue.y+dir[j][1]);
                
                if(checkout(nextRed, nextBlue, red, blue, maze)){
                    visited[0][nextRed.x][nextRed.y] = true;
                    visited[1][nextBlue.x][nextBlue.y] = true;
                    backTracking(nextRed, nextBlue, total+1, maze);
                    visited[0][nextRed.x][nextRed.y] = false;
                    visited[1][nextBlue.x][nextBlue.y] = false;
                }
            }
        }
        
    }
    public boolean checkout(Position red, Position blue, Position preRed, Position preBlue,
                            int[][] maze){
        // 판 밖으로는 안돼
        if(red.x<0 || red.x>=n || red.y<0 || red.y>=m ||
          blue.x<0 || blue.x>=n || blue.y<0 || blue.y>=m){
         
            return false;
        }
        // 벽은 안돼
        if(maze[red.x][red.y]==5 || maze[blue.x][blue.y]==5)
            return false;
        // 이미 방문한 칸은 안돼 -> 이미 완료한 수레는 배제 해야한다..
        if((!red.equals(red_end) && visited[0][red.x][red.y]) || 
           (!blue.equals(blue_end) && visited[1][blue.x][blue.y]))
            return false;
        // 동시에 같은 칸은 안돼
        if(red.equals(blue))
            return false;
        // 동시에 자리를 바꿀 수 없다.
        if(red.equals(preBlue) && blue.equals(preRed))
            return false;
        
        return true;
    }
}
