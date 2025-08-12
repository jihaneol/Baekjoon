import java.util.*;
class Solution {
    private int answer,n,m;
    private char[][] map;
    private int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int solution(String[] storage, String[] requests) {
        
        n=storage.length;
        m=storage[0].length();
        answer = n*m;
        // bfs 로 밖았 처리. 그냥 처리
        map = new char[n+2][m+2];
        for(int i=1; i<=n; i++){
            String s = storage[i-1];
            for(int j=1; j<=m; j++){
                map[i][j] = s.charAt(j-1);
            }
        }
        
        for(String request : requests){
            if(request.length()==1){
                bfs(request.charAt(0));    
            }else{
                for(int i=1; i<=n; i++){
                    for(int j=1; j<=m; j++){
                        if(map[i][j]==request.charAt(0)){
                            map[i][j]='x';
                            answer--;
                        }
                    }
                }
            }
        }
     
        return answer;
    
    }
    public void bfs(char target){
        // map -0 == 0 이면 아무 것도 없는것. add
        // !=0 이면 target과 일치하면 성공 add
        // 지나온 길 true로..  
        boolean[][] visited = new boolean[n+2][m+2];
        Queue<int[]> q = new ArrayDeque();
        q.add(new int[]{0,0});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int[] d : dir){
                int nx = d[0] + now[0];
                int ny = d[1] + now[1];
                if(nx<0 || ny<0 || nx>=n+2 || ny>=m+2) continue;
                if(visited[nx][ny]) continue;
                visited[nx][ny] = true;
                if(map[nx][ny]!='x' && map[nx][ny]-0!=0 && 
                   map[nx][ny]!=target) continue;
                
                if(map[nx][ny]==target){
                    answer--;
                    map[nx][ny]='x';
                }else{
                    q.add(new int[]{nx,ny});
                }
            }
        }
   
    }
}