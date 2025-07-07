class Solution {

    public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        //행 열 100만, 스킬 25만
        // 일 부분만 공격 한다. 1 이면 감소, 2이면 회복
        int[][] dp = new int[n+1][m+1];
        
        for(int[] s : skill){
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int d = s[5];
            // 공격
            if(s[0]==1){
                d = -d;
            }
            
            dp[r1][c1] +=d;
            dp[r2+1][c2+1] +=d;
            dp[r1][c2+1] -=d;
            dp[r2+1][c1] -=d;
            
        }
        // 상하
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dp[i+1][j] +=dp[i][j];
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] + dp[i][j] >0){
                    answer++;
                }
                dp[i][j+1] += dp[i][j];
            }
        }
        
        return answer;
    }

}