import java.util.*;
class Solution {
    private int[][] board;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        init(rows, columns);

        // 진짜 움직이고 , 그 중에서 가장 작은 놈 answer에 오름 차순으로 한다.
        for(int i = 0; i<queries.length; i++){
            int[] q = queries[i];
            answer[i] = rotation(q[0], q[1], q[2], q[3]);
        }

        return answer;
    }
    private void init(int rows, int columns){
        board = new int[rows+1][columns+1];
        
        for(int i=1; i<rows+1; i++){
            for(int j=1; j<columns+1; j++){
                board[i][j] = (i-1)*columns+j;
            }
        }
    }
    
    private int rotation(int x1, int y1, int x2, int y2){
        int value = board[x1][y1];
        int min = value;
        
        //왼쪽 위치
        for(int r=x1; r<x2; r++){
            int current = board[r+1][y1];
            board[r][y1] = current;
            min = Math.min(min, current);
        }
        // 아래 위치
        for(int c=y1; c<y2; c++){
            int current = board[x2][c+1];
            board[x2][c] = current;
            min = Math.min(min, current);
        }
        // 오른쪽 위치
         for(int r=x2; r>x1; r--){
            int current = board[r-1][y2];
            board[r][y2] = current;
            min = Math.min(min, current);
        }
        // 위쪽 위치
         for(int c=y2; c>y1; c--){
            int current = board[x1][c-1];
            board[x1][c] = current;
            min = Math.min(min, current);
        }
        
        board[x1][y1+1] = value;

        return min;
    }
}