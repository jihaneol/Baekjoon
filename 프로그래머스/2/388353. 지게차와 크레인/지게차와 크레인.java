import java.util.*;

class Solution {
    private int[] dx = {0,0,1,-1};
    private int[] dy = {1,-1,0,0};
    private char[][] map;
    private int n, m, answer;
    public int solution(String[] storage, String[] requests) {
   
        n = storage.length+2;
        m = storage[0].length()+2;
        map = new char[n][m];
        answer = (n-2)*(m-2);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = '0';
            }
        }
        
        for(int i=1; i<n-1; i++){
            for(int j=1; j<m-1; j++){
                map[i][j] = storage[i-1].charAt(j-1);
            }
        }
        
        for(String request : requests){
            bfs(request.length(), request.charAt(0));            
        }
        return answer;
    }
    private void bfs(int len, char target){
        
        Queue<int[]> q = new LinkedList();
        q.add(new int[] {0,0});
        if(len==2){
            for(int i=1; i<n-1; i++){
                for(int j=1; j<m-1; j++){
                    if(map[i][j]==target) {
                        map[i][j]='0';
                        answer--;
                    }
                }
            }
        }else{
            
            
            boolean[][] v = new boolean[n][m];
            while(!q.isEmpty()){
                int[] now = q.poll();
                
                for(int i=0; i<4; i++){
                    int nx = dx[i] + now[0];
                    int ny = dy[i] + now[1];
                    if(nx<0||ny<0||nx>=n||ny>=m||v[nx][ny]) continue;

                    v[nx][ny] = true;
                    
                    if(map[nx][ny]=='0') q.add(new int[] {nx,ny});
                    
                    if(map[nx][ny]==target) {
                        map[nx][ny] = '0';
                        answer--;
                    }
                 }
            }
           
            
            
        }
    }
}


