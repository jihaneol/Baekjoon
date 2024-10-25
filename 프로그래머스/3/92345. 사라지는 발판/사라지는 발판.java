class Solution {
    
    private class Player{
        boolean isWin;
        int num;
        Player(boolean w, int n){
            this.isWin = w;
            this.num = n;
        }
    }
    private int n,m;
    private int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        n = board.length;
        m = board[0].length;
        return play(board, aloc[0], aloc[1], bloc[0], bloc[1], 0).num;
    }
    
    private Player play(int[][] board
                        , int ax, int ay, int bx, int by,int cnt){
        
        if(board[ax][ay]==0){
            return new Player(false, 0);
        }
        board[ax][ay] = 0;
        int winner = Integer.MAX_VALUE;
        int loser = 0;
        boolean isEnd = true;
      
        for(int i=0; i<4; i++){
            int nx = dir[i][0] + ax;
            int ny = dir[i][1] + ay;
            if(!isRange(nx, ny) || board[nx][ny]==0) continue;
            isEnd = false;
            Player next = play(board, bx, by, nx, ny, cnt+1);
            // 난 졌다.
            if(next.isWin){
                loser = Math.max(loser, next.num);
            }else{
                winner = Math.min(winner, next.num);
            }
        }
        board[ax][ay] = 1;
        
        if(isEnd){
            return new Player(false, loser);
        }
        
        return winner==Integer.MAX_VALUE ? 
            new Player(false,loser+1) : new Player(true, winner+1);
        
    }
    private boolean isRange(int x, int y){
        return x>=0 && x<n && y>=0 && y<m;
    }
   
    
}