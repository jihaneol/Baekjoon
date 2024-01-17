
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int L,R,N;
    private static int[][] map;
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    private static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        L = Integer.valueOf(st.nextToken());
        R = Integer.valueOf(st.nextToken());
        map = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        int answer = 0;
        Queue<Point> union = new LinkedList<>();
        Queue<Point> q = new LinkedList<>();
        while(true) {
            for(int i=0; i<N; i++){
                Arrays.fill(visited[i],false);
            }
            boolean flag = true;
            for (int i = 0; i < N; i++) {
                for (int j = i % 2; j < N; j = j + 2) {
                    if (visited[i][j]) continue;

                    int total = move(i, j, visited, union,q);
                    if (union.size() ==1) {
                        
                        union.poll();
                        continue;
                    }
                    flag = false;
                    int totalNum = total / union.size();

                    while (!union.isEmpty()) {
                        Point p = union.poll();
                        map[p.x][p.y] = totalNum;
                    }


                }
            }
            if(flag) break;
            answer++;

        }
        System.out.println(answer);

    }
    private static int move(int row, int col, boolean[][] visited, Queue<Point> union,Queue<Point> q){

        int total = map[row][col];
        visited[row][col] = true;
        q.add(new Point(row,col));

        while(!q.isEmpty()){
            Point now = q.poll();
            union.add(now);
            for(int i=0 ; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(!isRange(nx,ny) || visited[nx][ny]) continue;
                int diff = Math.abs(map[now.x][now.y]-map[nx][ny]);
                if(L<=diff && R>=diff){
                    total+=map[nx][ny];
                    q.add(new Point(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }

        return total;
    }

    private static boolean isRange(int nx, int ny) {
        return nx>=0 && ny>=0 && nx<N && ny<N;
    }


}


