class Solution {
    private  class Position {
        int x,y;
        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
        public Position next(int dir){
            return new Position(x+dx[dir], y+dy[dir]);
        }
    }
    private int[][] map;
    private  int[] dx = {-1,1,0,0};
    private  int[] dy = {0,0,-1,1};
    private  boolean visited[][][], redEnd, blueEnd;
    private int answer = 20;

    public int solution(int[][] maze) {
        this.map = maze;
        Position blue_position = null;
        Position red_position = null;
        visited = new boolean[maze.length][maze[0].length][2];// 0 레드, 1 브루

        for(int i=0; i<maze.length; i++){
            for(int j=0; j<maze[i].length; j++){
                switch(maze[i][j]){
                    case 1: 
                        red_position = new Position(i,j);
                        visited[i][j][0] = true;
                        break;
                    case 2 : 
                        blue_position = new Position(i,j);
                        visited[i][j][1] = true;
                        break;
                }
            }
        }

       backtracking(red_position,blue_position,0);

        return answer==20?0:answer;
    }
    private void backtracking(Position red_position, Position blue_position, int result){

        if(redEnd && blueEnd) {
            answer = Math.min(answer, result);
            return;
            
        }
     

        // 수레 움직이기 완탐.
        for(int i=0; i<4; i++){
            Position nextRed = !redEnd? red_position.next(i):red_position;
            for(int j=0; j<4; j++){
                Position nextBlue = !blueEnd ? blue_position.next(j):blue_position;

                if(!isPossible(nextRed, nextBlue, red_position, blue_position)) continue; 

                visited[nextRed.x][nextRed.y][0] = true;
                visited[nextBlue.x][nextBlue.y][1] = true;

                if(map[nextRed.x][nextRed.y] == 3) redEnd = true;
                if(map[nextBlue.x][nextBlue.y] == 4) blueEnd = true;

                backtracking(nextRed, nextBlue,result+1);

                visited[nextRed.x][nextRed.y][0] = false;
                visited[nextBlue.x][nextBlue.y][1] = false;

                blueEnd = false;
                redEnd = false;

            }
        }
    }


    // 다음 , 다음, 현재, 현재
    private  boolean isPossible(Position red, Position blue, Position cntRed, Position cntBlue){
        // 밖으로 못빠지고 벽 아니다.
        if(red.x<0 || red.y<0 || blue.x<0 || blue.y<0 || 
           red.x>=map.length || red.y>=map[0].length || blue.x>=map.length || blue.y>=map[0].length || 
          map[red.x][red.y] == 5 || map[blue.x][blue.y] == 5){
            return false;
        }
        // 방문 칸 안돼
        if((!redEnd && visited[red.x][red.y][0]) || (!blueEnd && visited[blue.x][blue.y][1])) return false;
        // 동시에 같은 칸 안돼
        if(red.x==blue.x && red.y==blue.y) return false;
        // 수레끼리 자리 못 바꿈
        if((red.x==cntBlue.x && red.y==cntBlue.y) && (blue.x==cntRed.x && blue.y==cntRed.y)) return false;
        return true;
    }
}