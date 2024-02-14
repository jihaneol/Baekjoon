import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    private static int N, M;

    private static class Aircon {
        int x, y, d;

        Aircon(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int answer = 0;
        int[][] map = new int[N][M];
        boolean[][] countMap = new boolean[N][M];

        Deque<Aircon> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    for (int c = 0; c < 4; c++) {
                        queue.add(new Aircon(i, j, c));
                    }
                    answer++;
                    countMap[i][j] = true;
                }
            }
        }
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            Aircon now = queue.poll();
            int d = now.d;
            int nx = now.x + dir[d][0];
            int ny = now.y + dir[d][1];
            while (true) {

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) break;
                if (!countMap[nx][ny]) {
                    answer++;
                    countMap[nx][ny] = true;
                }
                if(map[nx][ny]==0){
                    nx += dir[d][0];
                    ny += dir[d][1];
                    continue;
                }

                if (map[nx][ny] == 3) {
                    switch (d) {
                        case 0:
                            d = 1;
                            break;
                        case 1:
                            d = 0;
                            break;
                        case 2:
                            d = 3;
                            break;
                        case 3:
                            d = 2;
                    }
                } else if (map[nx][ny] == 4) {
                    switch (d) {
                        case 0:
                            d = 3;
                            break;
                        case 1:
                            d = 2;
                            break;
                        case 2:
                            d = 1;
                            break;
                        case 3:
                            d = 0;
                    }
                } else if (map[nx][ny] == 1 && (d == 1 || d == 3)) {
                    break;
                } else if (map[nx][ny] == 2 && (d == 0 || d == 2)) {
                    break;
                }

                nx += dir[d][0];
                ny += dir[d][1];
            }
        }


        System.out.println(answer);

    }

}