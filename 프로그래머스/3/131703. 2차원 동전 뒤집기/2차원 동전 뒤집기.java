class Solution {
    int n, m, answer;
    int[][] board;
    int[][] t;
    final int INF = 10000;
    public int solution(int[][] beginning, int[][] target) {
        answer = INF;
        n = beginning.length;
        m = beginning[0].length;
        
        board = new int[n][m];
        for(int i=0; i<n; i++){
            board[i] = beginning[i].clone();
        }
        t = target;
        
        dfs(0, 0);
        
        return answer == INF ? -1 : answer;
    }
    
    public void flip_row(int r){
        for(int i=0; i<m; i++){
            board[r][i] ^= 1;
        }
    }
    
    public int compare_col(int c){
        int check = 0;
        for(int i=0; i<n; i++){
            if(t[i][c]==board[i][c]){
                check++; 
            } 
        }
        
        if(check==n) return 0; //전부 일치
        else if(check==0) return 1; //전부 불일치
        else return -1;
    }
    
    public void dfs(int r, int cnt){
        if(r==n){
            for(int i=0; i<m; i++){
                int result = compare_col(i);
                if(result==-1){
                    return;
                }
                cnt += result; //전부 반대일 경우 +1
            }
            
            answer = Math.min(answer, cnt);   
            
            return;
        }
        
        flip_row(r); 
        dfs(r+1, cnt+1); 
        flip_row(r); 
        
        dfs(r+1, cnt); 
    }
}