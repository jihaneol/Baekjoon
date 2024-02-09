import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[][][] arr = {{{1}, {2}, {3}, {4}},
            {{1, 3}, {2, 4}},
            {{1, 2}, {2, 3}, {3, 4}, {1, 4}},
            {{1, 2, 4}, {1, 2, 3}, {2, 3, 4}, {4, 3, 1}},
            {{1, 2, 3, 4}}};
    /**
     * 초반에 한짓 지우기
     * private static int[][][] arr2 = {{{1}, {2}, {3}, {4}},
     * {{1, 3}, {2, 4}},
     * {{1}, {2}, {3}, {1, 4}},
     * {{4}, {1}, {2}, {1, 3, 4}},
     * {{1, 2, 3, 4}}};
     */

    private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};


    private static List<Position> cctv;

    private static int total, answer, n, m, blindSpot;

    private static class Position {
        int x, y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        // 감시 하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        cctv = new ArrayList<>();
        total = 0; //
        blindSpot = 0;
        answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctv.add(new Position(i, j));
                } else if (map[i][j] == 0) {
                    blindSpot++;
                }

            }
        }

        solution(0, map);

        System.out.println(blindSpot - answer);


    }

    public static void solution(int depth, int[][] originMap) {

        if (cctv.size() == depth) {
            if (answer < total) {
                answer = total;
            }
            return;
        }

        Position now = cctv.get(depth);
        int num = originMap[now.x][now.y];

        for (int i = 0; i < arr[num - 1].length; i++) {
            int[][] tempMap = copyMap(originMap);
            int tempTotal = 0;
            // 그리기
            for (int j = 0; j < arr[num - 1][i].length; j++) {
                tempTotal += go(now.x, now.y, arr[num - 1][i][j], tempMap);
            }
            total += tempTotal;
            solution(depth + 1, tempMap);
            // 지우기
            total -= tempTotal;
        }

    }

    public static int[][] copyMap(int[][] map) {
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }

    // 7이 감시할 수 있는 영역
    public static int go(int x, int y, int d, int[][] map) {
        int nx = x;
        int ny = y;
        int temp = 0;
        while (true) {
            nx += dir[d - 1][0];
            ny += dir[d - 1][1];
            if (isRange(nx, ny)) {
                if (map[nx][ny] == 6) return temp;
                if (map[nx][ny] == 0) {
                    map[nx][ny] = 7;
                    temp++;
                }
            } else {
                return temp;
            }
        }
    }


    public static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

}
