
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static char[][] map;
    private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = row.charAt(j);
            }
        }
        int total = 0;
        List<int[]> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '.') continue;

                map[i][j] = '.';
                if (dfs(n)) {
                    total++;
                    sb.append((i+1) +" "+(j+1)).append('\n');
                }
                map[i][j] = '#';
            }
        }

        System.out.println(total);
        System.out.println(sb.toString());

    }

    private static boolean dfs(int n) {
        boolean[][] visited = new boolean[n][n]; // 스택에 넣었는지 확인용..
        int[][] cycle = new int[n][n]; // 사이클 확인용
        for (int i = 0; i < n; i++) {
            Arrays.fill(cycle[i], -1);
        }
        Stack<int[]> stack = new Stack<>();
        int area = 0;
        // 사이클 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // # 찾기
                if (map[i][j] == '.') continue;
                if (cycle[i][j] >= 0) continue;
                // stack에 넣었다는 표시
                visited[i][j] = true;
                stack.push(new int[]{i, j, -1, -1});
                // 지역 번호 표시
                area++;

                while (!stack.isEmpty()) {
                    int[] now = stack.pop();

                    for (int[] d : dir) {
                        int nx = now[0] + d[0];
                        int ny = now[1] + d[1];

                        // 부모면 continue;
                        if (nx == now[2] && ny == now[3]) continue;

                        if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                        // stack에 넣었거나 갈수없는 곳이라면
                        if (visited[nx][ny] || map[nx][ny] == '.') continue;

                        // 이미 지나간 길인데 간다면.
                        if (cycle[nx][ny] >= 0) return false;

                        cycle[nx][ny] = area;
                        stack.push(new int[]{nx, ny, now[0], now[1]});
                    }
                }

            }
        }

        return area == 1;
    }
}