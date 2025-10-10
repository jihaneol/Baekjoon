class Solution {
    class Pos{
        int x, y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private StringBuilder sb = new StringBuilder(); 
    private int[][] dir = {{1,0},{0,-1},{0,1},{-1,0}};
    private char[] word = {'d', 'l', 'r', 'u'}; 
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
  
        // d, l, r, u, 
        // 필요 이동 거리 k
        // 현재 거리 10, = 남은 거리 10 이면  도착지로 이동해야한다.
        // 현재 거리 4,  < 남은 거리 10 이면 사전순으로 이동한다.
        // 현재 거리 10 > 남은 거리 4 이면 실패다.
        Pos now = new Pos(x-1, y-1);
        Pos end = new Pos(r-1, c-1);
        
        for(int remainDist=k; remainDist>=0; remainDist--){
            int dist = getDist(now, end); //현재 거리
            if(dist > remainDist) return "impossible";
            
            if(dist == remainDist) goDestination(now, end, n, m);
            
            if(dist < remainDist) goDictionary(now, end, n, m);
            
        }
        
        return sb.toString();
    }
    private void goDictionary(Pos now, Pos end, int n, int m){
        for(int i=0; i<4; i++){
            int nx = now.x + dir[i][0];
            int ny = now.y + dir[i][1];

            if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
            
            
            now.x = nx;
            now.y = ny;
            sb.append(word[i]);  
            break;
        }
    }
    private void goDestination(Pos now, Pos end, int n, int m){
        for(int i=0; i<4; i++){
            int nx = now.x + dir[i][0];
            int ny = now.y + dir[i][1];
            
            if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
            
            int nowDist = getDist(now, end);
            int nextDist = getDist(new Pos(nx,ny), end);
            
            if(nowDist<=nextDist) continue;
                
            now.x = nx;
            now.y = ny;
            sb.append(word[i]);  
            break;
        }
    }
    private int getDist(Pos now, Pos end){
        return Math.abs(now.x-end.x) + Math.abs(now.y-end.y);
    }
}