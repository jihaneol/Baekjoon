class Solution {
    private int n, m, answer;
    final int INF = 100000;
    private int[][] board, t;
    public int solution(int[][] beginning, int[][] target) {
        answer = INF;
        n = beginning.length;
        m = beginning[0].length;
        
        board = new int[n][m];
        t = new int[n][m];
        for(int i=0; i<n; i++){
            board[i] = beginning[i].clone();
            t[i] = target[i].clone();
        }
        dfs(0,0);
        return answer==INF ? -1 : answer;
    }
    
    private void flipRow(int row){
        for(int i=0; i<m; i++){
            board[row][i] ^= 1;
        }
    }
    private int compareCol(int col){
        int cnt = 0;
        for(int i=0; i<n; i++){
            if(board[i][col] == t[i][col]){
                cnt++;
            }
        }
        if(cnt==0) return 1;
        else if(cnt == n) return 0;
        else return -1;
    }
    private void dfs(int depth, int total){
        if(depth == n){
            for(int i=0; i<m; i++){
                int cnt = compareCol(i);
                if(cnt==-1){
                    return;
                }
                total+=cnt;
            }
            answer = Math.min(answer,total);
            return;
        }
        
        flipRow(depth);
        dfs(depth+1, total+1);
         
        flipRow(depth);
        
        dfs(depth+1, total);
        
        return;
    }
    
  
}