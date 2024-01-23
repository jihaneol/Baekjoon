import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Point {
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;

        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] dr = {{1,0},{0,-1},{-1,0},{0,1}};
        boolean[][] map = new boolean[101][101];

        while(N-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            Deque<Point> q = new ArrayDeque<>();
            Deque<Point> addQ = new ArrayDeque<>();
            int dx = x + dr[d][0];
            int dy = y + dr[d][1];

            // 끝점 먼저 넣자
            q.add(new Point(dx,dy));
            q.add(new Point(x,y));
            map[x][y] = true;
            map[dx][dy] = true;


            while(g-->0){
                Point endPoint = q.poll(); //3
                Point target = new Point(endPoint.x,endPoint.y); //끝점
                Point pre = new Point(endPoint.x,endPoint.y);
                int size = q.size();

                q.add(endPoint);

                for(int i=0; i<size; i++){
                    Point now = q.poll(); //2
                    q.add(now);
                    int dir = nextPoint(pre,now,target)-1;
                    if(dir<0) dir = 3;
                    pre = now;
                    int nx = endPoint.x + dr[dir][0];
                    int ny = endPoint.y + dr[dir][1];
                    endPoint = new Point(nx,ny);
                    if(!isRange(nx,ny)) continue;
                    map[nx][ny] = true;
                    addQ.add(endPoint);


                }

                while(!addQ.isEmpty()){
                    q.addFirst(addQ.poll());
                }
            }
        }
        int answer = 0;
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(!map[i][j] || !map[i][j+1] || !map[i+1][j] || !map[i+1][j+1]) continue;
                else answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean isRange(int nx, int ny) {
        return nx>=0 && ny>=0 && nx<=100 && ny<=100;
    }

    private static int nextPoint(Point start, Point end,Point target){
        // 0 아래, 1 왼, 2위, 3 오른쪽
        // 0 -> 1, 1-> 2, 3 ->0 , 2-> 3 이것 때문에 .. 문제를 잘읽자
        int dir;
        if(start.x==end.x && end.y<start.y){
            dir = 1;
        }else if(start.x==end.x && start.y<end.y){
            dir = 3;
        }else if(start.y==end.y && start.x<end.x){
            dir = 0;
        }else{
            dir = 2;
        }

        // 타겟 보다 위냐 아래냐 옆이냐 따라 90도 변함

        return dir;
    }


}