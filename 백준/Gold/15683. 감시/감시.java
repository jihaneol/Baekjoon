import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int n, m, ans;
    private static int[][] map;
    private static int[][] dir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    private static int[][][] cctv =
            {{}
                    , {{0}, {1}, {2}, {3}}
                    , {{0, 2}, {1, 3}}
                    , {{0, 1}, {1, 2}, {2, 3}, {0, 3}}
                    , {{0, 1, 2}, {0, 1, 3}, {2, 3, 0}, {1, 2, 3}}
                    , {{1, 2, 3, 0}}};

    private static List<Pos> aircons = new ArrayList<>();

    public static class Pos {
        int x, y, no;

        Pos(int x, int y, int no) {
            this.x = x;
            this.y = y;
            this.no = no;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        ans = 65;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0 && map[i][j] < 6) {
                    aircons.add(new Pos(i, j, map[i][j]));
                } else if (map[i][j] == 0) cnt++;
            }
        }

        dfs(0, cnt, aircons.size());

        System.out.println(ans);
    }

    public static void dfs(int depth, int spot, int max) {
        if (max == depth) {
            // 사각지대 수 체크
            if (ans > spot)
                ans = spot;
            return;
        }

        Pos now = aircons.get(depth);
        Queue<Pos> q = new LinkedList<>();

        for (int[] d : cctv[now.no]) {

            int cnt = 0;
            // 7 추가
            for (int idx : d) {
                int dx = dir[idx][0];
                int dy = dir[idx][1];

                int nx = now.x + dx;
                int ny = now.y + dy;
                while (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] != 6) {

                    if (map[nx][ny] == 0) {
                        cnt++;
                        map[nx][ny] = 7;
                        q.add(new Pos(nx, ny, 7));
                    }

                    nx += dx;
                    ny += dy;

                }
            }
            dfs(depth + 1, spot - cnt, max);
            // 7 삭제
            while (!q.isEmpty()) {
                Pos del = q.poll();

                map[del.x][del.y] = 0;
            }
        }


    }
}