import java.util.*;
class Solution {
    
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        
        for(int i=0; i<4; i++){
            int nx = h+dir[i][0];
            int ny = w+dir[i][1];
            if(nx<0 || ny<0 || ny>=board[0].length || nx>=board.length) continue;
            
            if(board[nx][ny].equals(board[h][w])){
                answer++;
            }
        }
        
        return answer;
    }
    
    
}