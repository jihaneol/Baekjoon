class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;
        int[][] skillboard = new int[N][M];
        
        int sum = 0;
        
        int[] sumlist = new int[M];
        
        for(int[] s : skill){
            int comm = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];
            
            if(comm==1){
                skillboard[r1][c1] -= degree;
                if(c2+1<M){
                    skillboard[r1][c2+1] +=degree;
                }
                
                if(r2+1<N){
                    skillboard[r2+1][c1] +=degree;
                }
                if(r2+1<N && c2+1<M)
                    skillboard[r2+1][c2+1] -=degree;
            }else{
                skillboard[r1][c1] += degree;
                if(c2+1<M){
                    skillboard[r1][c2+1] -=degree;
                }
                
                if(r2+1<N){
                    skillboard[r2+1][c1] -=degree;
                }
                 if(r2+1<N && c2+1<M)
                    skillboard[r2+1][c2+1] +=degree;
                
            }
        }
        
        for(int i=0; i<N; i++){
            sum = 0;
            for(int j=0; j<M; j++){
                sum+=skillboard[i][j];
                sumlist[j] += sum;
                
                if(board[i][j] + sumlist[j] >0) answer++;
            }
        }
        
        return answer;
    }
}
