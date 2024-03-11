import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int N, Q, pow, max, total;
    static int[][] map;
    static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        pow = (int) Math.pow(2, N);
        map = new int[pow][pow];

        for (int i = 0; i < pow; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < pow; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());

        while (Q-- > 0) {
            int L = Integer.parseInt(st.nextToken());
            int powL = (int) Math.pow(2, L);

            divid(powL);

            bfs();

        }
        max = 0;
        total = 0;
        result();


        System.out.println(total+"\n" + max);

    }

    private static void result() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[pow][pow];
        for(int i=0; i<pow; i++){
            for(int j=0; j<pow; j++){
                if(map[i][j]!=0){
                    int cnt = 1;
                    q.add(new int[] {i,j});
                    visited[i][j] = true;
                    while(!q.isEmpty()){
                        int[] now = q.poll();
                        total+=map[now[0]][now[1]];
                        map[now[0]][now[1]] = 0;
                        for (int c = 0; c < 4; c++) {
                            int nx = now[0] + dir[c][0];
                            int ny = now[1] + dir[c][1];
                            if (!isRange(nx, ny) || map[nx][ny] == 0 || visited[nx][ny]) continue;
                            cnt++;
                            visited[nx][ny] = true;
                            q.add(new int[] {nx,ny});
                        }
                    }
                    max = Math.max(max,cnt);
                }
            }
        }
    }

    private static void divid(int powL) {
        int[][] temp = new int[pow][pow];
        for (int y = 0; y < pow; y += powL) {
            for (int x = 0; x < pow; x += powL) {
                rotate(x, y, powL, temp);
            }
        }
        map = temp;
    }

    private static void bfs() {
        // 인접 안하면 얼음양 1 줄어든다.
        int[][] temp = new int[pow][pow];
        for (int i = 0; i < pow; i++) {
            temp[i] = map[i].clone();
        }
        for (int i = 0; i < pow; i++) {
            for (int j = 0; j < pow; j++) {
                int cnt = 0;
                if(map[i][j]==0) continue;
                for (int c = 0; c < 4; c++) {
                    int nx = i + dir[c][0];
                    int ny = j + dir[c][1];
                    if (!isRange(nx, ny) || map[nx][ny] == 0) continue;
                    cnt++;
                }
                if (cnt < 3) {
                    temp[i][j]--;
                }
            }
        }
        map = temp;
    }

    private static boolean isRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < pow && ny < pow;
    }

    private static void rotate(int x, int y, int powL, int[][] temp) {
        //돌리기
        for (int i = 0; i < powL; i++) {
            for (int j = 0; j < powL; j++) {
                temp[x + j][powL - 1 - i + y] = map[i + x][j + y];
            }
        }
    }
}