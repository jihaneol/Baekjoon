class Solution {
    private int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    private int answer = Integer.MAX_VALUE;
    private int n,m;
    private class Player{
        boolean isWin;
        int cnt;
        Player(boolean w, int c){
            isWin = w;
            cnt = c;
        }
    }
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        n = board.length;
        m = board[0].length;
        return play(board,aloc[0], aloc[1], bloc[0], bloc[1],0).cnt;
    }
    public Player play(int[][] board, int ax, int ay, int bx, int by,int cnt){
    
       if(isEnd(board,ax,ay) || board[ax][ay]==0){
           return new Player(false, cnt);
       }
     
        int loseMax = -1; // 지면 최대한 길게
        int winMin = Integer.MAX_VALUE; // 이기면 최대한 짧게
        board[ax][ay] = 0;
        for(int i=0; i<4; i++){
            int nx = ax + dir[i][0];
            int ny = ay + dir[i][1];
            if(!isRange(nx,ny) || board[nx][ny]==0) continue;
            Player p = play(board, bx, by, nx, ny, cnt+1);
            if(p.isWin){
                loseMax = Math.max(p.cnt, loseMax);
            }else{
                winMin = Math.min(p.cnt, winMin);
            }
          
        }
          board[ax][ay] = 1;

        if(winMin!=Integer.MAX_VALUE){
            return new Player(true, winMin);
            
        }
        return new Player(false, loseMax);
        
    }
    public boolean isEnd(int[][] board, int x, int y){
        for(int i=0; i<4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(!isRange(nx,ny) || board[nx][ny]==0) continue;
            return false;
        }
        return true;
    }
    public boolean isRange(int x, int y){
        return x>=0 && y>=0 && x<n && y<m;
    }
}