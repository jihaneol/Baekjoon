import java.util.*;
class Solution {
    class Robot{
        int x, y, no, next;
        Robot(int x, int y, int no){
            this.x = x;
            this.y = y;
            this.no = no;
            this.next = 1;
        }
        public void setDir(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int m = routes[0].length; 
        Queue<Robot> q = new ArrayDeque();
        int[][] map = new int[101][101];
        for(int id=0; id<routes.length; id++){
            int[] route = routes[id];
            int[] point = points[route[0]-1];
            int x = point[0];
            int y = point[1];

            q.add(new Robot(x, y, id));
        }
        
        while(!q.isEmpty()){
            int size = q.size();
            // 충돌 계산
            answer+=clushCal(map, q);
            while(size-->0){
                Robot now = q.poll();    
                map[now.x][now.y]--;
                if(now.next >=m) continue;
                
                for(int[] d : dir){
                    int nx = now.x + d[0];
                    int ny = now.y + d[1];
                    
                    if(nx<1 || ny<1 || nx>100 || ny>100) continue;
                    
                    // 이동할 포인트
                    int[] point = points[routes[now.no][now.next]-1];
                    int nowDir = Math.abs(now.x-point[0])+Math.abs(now.y-point[1]);
                    int nextDir = Math.abs(nx-point[0])+Math.abs(ny-point[1]);
                    if(nowDir > nextDir){
                        if(nextDir == 0){
                            now.next++;
                        }
                        now.setDir(nx,ny);
                        q.add(now);
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
    private int clushCal(int[][] map,Queue<Robot> q){
        int result = 0;
        for(Robot now : q){
            map[now.x][now.y]++;
            if(map[now.x][now.y]==2) result++;
        }
    return result;
    }
}