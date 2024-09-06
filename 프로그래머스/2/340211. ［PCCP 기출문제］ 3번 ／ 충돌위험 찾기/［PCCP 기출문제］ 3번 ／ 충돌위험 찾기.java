import java.util.*;
class Solution {
    private int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public class Pos{
        int id,x,y,next;
        Pos(int id, int x, int y, int next){
            this.id = id;
            this.x = x;
            this.y = y;
            this.next = next;
        }
    }
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int lastRouteNum = routes[0].length;
        Queue<Pos> q = new LinkedList();
        for(int i=0; i<routes.length; i++){
            int s = routes[i][0]-1;
            q.add(new Pos(i,points[s][0],points[s][1],1));
        }
        int[][] map = new int[101][101];
        
        while(!q.isEmpty()){
            // 위험 상황 확인.
            for(Pos now : q){
                map[now.x][now.y]++;
                if(map[now.x][now.y]==2){
                    answer++;
                }
            }
            //이동
            int size= q.size();
            while(size--!=0){
                Pos now = q.poll();
                map[now.x][now.y]--;
                //마지막 위치면 끝.
                if(now.next == lastRouteNum){
                    continue;
                }
                Pos next = getOptimalPos(now, points[routes[now.id][now.next]-1]);
                q.add(next);
            }
        }
      
        return answer;
    }
    
    public Pos getOptimalPos(Pos now, int[] points){
        int nowDist = Math.abs(points[0]-now.x) + Math.abs(points[1]-now.y);
        Pos result = null;
        for(int i=0; i<4; i++){
            int nx = now.x + dir[i][0];
            int ny = now.y + dir[i][1];
            
            if(nowDist>Math.abs(points[0]-nx) + Math.abs(points[1]-ny)){
                result = new Pos(now.id,nx,ny,now.next);
                if(nowDist==1){
                    result.next++;
                }
                break;
            }
        }
        return result;
    }
}