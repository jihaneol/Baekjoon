import java.util.*;
class Solution {
    class Robot{
        int x, y, idx, nextPoint;
        Robot(int x, int y, int idx){
            this.x = x;
            this.y = y;
            this.idx = idx;
            this.nextPoint = 1;
        }
    }
    private int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        // r 좌표가 먼저 변하는 이동을 먼저한다.(-1,0)(1,0)(0,-1)(0,1) 맨해튼 거리로 가까워지면
        Queue<Robot> q = new ArrayDeque();
        // 충돌 확인 map
        Map<String, Integer> crashMap = new HashMap();
        int endPoint = routes[0].length;
        // q에 로봇 위치 넣기
        for(int i=0; i<routes.length; i++){
            int[] route = routes[i];
            int x = points[route[0]-1][0];
            int y = points[route[0]-1][1];
            q.add(new Robot(x, y, i));
        }
        
        while(!q.isEmpty()){
            int len = q.size();
            while(len-->0){
                Robot now = q.poll();
                String key = now.x+","+now.y;
                crashMap.put(key, crashMap.getOrDefault(key, 0)+1);
                
                // 다음 포인트가 없으면
                if(now.nextPoint>=endPoint) continue;
                
               
                int[] next = points[routes[now.idx][now.nextPoint]-1];
           
                // 아래
                for(int i=0; i<4; i++){
                    int nx = now.x + dir[i][0];
                    int ny = now.y + dir[i][1];
                        
                    if(Math.abs(now.x-next[0])+Math.abs(now.y-next[1]) > 
                       Math.abs(nx-next[0])+Math.abs(ny-next[1]))
                    {
                   
                        now.x = nx;
                        now.y = ny;
                        // 다음 위치가 point 면
                        if(next[0]==nx && next[1]==ny){
                            now.nextPoint+=1;
                        }
                        q.add(now);
                        break;
                    }
                }
            }
            // 충돌 확인
            for(int i : crashMap.values()){
                if(i>1){
                    answer ++;
                }
            }
            crashMap.clear();
        }
        
        return answer;
    }
}