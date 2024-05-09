import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static Queue<int[]> q = new LinkedList<>();
    static Queue<int[]> wallPositionQueue = new LinkedList<>();

    static boolean[][] visited;

    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    static int[][] map;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            char[] charArray = br.readLine().toCharArray();
            for(int j=0; j<m; j++){
                map[i][j] = charArray[j] - '0';
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && map[i][j] == 0){
                    visited[i][j] = true;
                    bfs(i,j);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                sb.append(map[i][j]%10);
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());

    }

    private static void bfs(int i, int j) {
        q.add(new int[] {i, j});
        int sum = 1;
        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int c=0; c<4; c++){
                int nx = now[0] + dir[c][0];
                int ny = now[1] + dir[c][1];

                if(!isRange(nx, ny)) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                if(map[nx][ny] == 0){
                    q.add(new int[] {nx,ny});
                    sum++;
                }else{
                    wallPositionQueue.add(new int[] {nx, ny});
                }
            }
        }

        while(!wallPositionQueue.isEmpty()){
            int[] now = wallPositionQueue.poll();
            map[now[0]][now[1]] += sum;
            visited[now[0]][now[1]] = false;
        }


    }

    private static boolean isRange(int nx, int ny) {
        return nx>=0 && ny>=0 && nx<n && ny<m;
    }

}