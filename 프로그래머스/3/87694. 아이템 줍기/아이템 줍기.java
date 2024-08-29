import java.util.*;
class Solution {
    int[][] board = new int[105][105];
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        // 선은 1 내부는 2;
        // 2배해준다.
        for(int[] rect : rectangle){
            makeRectangle(rect[0]*2, rect[1]*2, rect[2]*2, rect[3]*2);
        }
    
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{characterX*2, characterY*2});
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        boolean flag = true;
        while(flag){
            int size = q.size();
            answer++;
            for(int i=0; i<size; i++){
                int[] now = q.poll();
            
                if(now[0]==itemX*2 && now[1]==itemY*2){
                    flag = false;
                    break;
                }
                board[now[0]][now[1]] = 0;
                for(int j=0; j<4; j++){
                    int nx = now[0] + dir[j][0];
                    int ny = now[1] + dir[j][1];
                    if(board[nx][ny]==1){
                        q.add(new int[] {nx,ny});
                    }
                }
            }
            
        }
        return answer/2;
    }
    public void makeRectangle(int x1, int y1, int x2, int y2){
        //선 그리기
        for(int i=x1; i<=x2; i++){
            if(board[i][y1]==0) 
                board[i][y1] = 1;
            if(board[i][y2]==0)
                board[i][y2] = 1;
           
        }
        
        for(int j=y1; j<=y2; j++){
            if(board[x1][j]==0)
                board[x1][j]=1;
                
            if(board[x2][j]==0){
                board[x2][j]=1;
            }
        }
        
        //내부 채우기
        for(int i=x1+1; i<=x2-1; i++){
            for(int j=y2-1; j>=y1+1; j--){
                board[i][j] = 2;
            }
        }
    }
}