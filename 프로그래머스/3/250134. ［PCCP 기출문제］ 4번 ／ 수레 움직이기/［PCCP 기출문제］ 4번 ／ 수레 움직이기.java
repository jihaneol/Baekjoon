class Solution {
    private static class Position {
        int x,y;
        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static int[][] map;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static boolean visited[][][], redEnd, blueEnd;


    public int solution(int[][] maze) {
        map = new int[maze.length][maze[0].length];
        int answer = 0;
        Position blue_position = null;
        Position red_position = null;
        visited = new boolean[maze.length][maze[0].length][2];// 0 레드, 1 브루

        for(int i=0; i<maze.length; i++){
            for(int j=0; j<maze[i].length; j++){
                map[i][j] = maze[i][j];
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

        answer = backtracking(red_position,blue_position,0);

        return answer==20?0:answer;
    }
    private static int backtracking(Position red_position, Position blue_position, int result){

        if(redEnd && blueEnd) {
        
            return result;
        }
        int min = 20;

        // 수레 움직이기 완탐.
        for(int i=0; i<4; i++){
            Position nextRed = !redEnd? nextPosition(red_position,i):red_position;
            if(!isRange(nextRed.x, nextRed.y))continue;
            for(int j=0; j<4; j++){
                Position nextBlue = !blueEnd ? nextPosition(blue_position, j):blue_position;
                if(!isRange(nextBlue.x, nextBlue.y) || !isPossible(nextRed, nextBlue, red_position, blue_position)) continue; 

                visited[nextRed.x][nextRed.y][0] = true;
                visited[nextBlue.x][nextBlue.y][1] = true;

                if(map[nextRed.x][nextRed.y] == 3) redEnd = true;
                if(map[nextBlue.x][nextBlue.y] == 4) blueEnd = true;

                min = Math.min(min,backtracking(nextRed, nextBlue,result+1));

                visited[nextRed.x][nextRed.y][0] = false;
                visited[nextBlue.x][nextBlue.y][1] = false;

                blueEnd = false;
                redEnd = false;

            }
        }
        return min;
    }

    private static Position nextPosition(Position p, int dir){
        return new Position(p.x+dx[dir], p.y+dy[dir]);
    }
    private static boolean isRange(int x, int y){
        // 밖으로 못빠지고 벽 아니다.
        if(x<0 || y<0  || x>=map.length || y>=map[0].length 
           || map[x][y] == 5){
            return false;
        }
        return true;
    }
    // 다음 , 다음, 현재, 현재
    private static boolean isPossible(Position red, Position blue, Position cntRed, Position cntBlue){
        
        // 방문 칸 안돼
        if((!redEnd && visited[red.x][red.y][0]) || (!blueEnd && visited[blue.x][blue.y][1])) return false;
        // 동시에 같은 칸 안돼
        if(red.x==blue.x && red.y==blue.y) return false;
        // 수레끼리 자리 못 바꿈
        if((red.x==cntBlue.x && red.y==cntBlue.y) && (blue.x==cntRed.x && blue.y==cntRed.y)) return false;
        return true;
    }
}