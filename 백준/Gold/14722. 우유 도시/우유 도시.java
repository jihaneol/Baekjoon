import java.io.*;
import java.util.*;


public class Main {
    static int[][] map;
    static int N;
    static int[][][] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        map = new int[N + 1][N + 1];
        dp = new int[3][N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0) dp[0][i][j]=1;
            }
        }




        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int now = map[i][j];
                int pre = now - 1 == -1 ? 2 : now - 1;
                // 먹을수 있다.
                if (dp[pre][i - 1][j] != 0 || dp[pre][i][j - 1] != 0) {
                    dp[now][i][j] = Math.max(dp[pre][i - 1][j] + 1, dp[pre][i][j - 1] + 1);
                }
                // 다 갱신
                for (int c = 0; c < 3; c++) {
                    dp[c][i][j] = Math.max(dp[c][i - 1][j], dp[c][i][j]);
                    dp[c][i][j] = Math.max(dp[c][i][j - 1], dp[c][i][j]);
                }
            }
        }


        System.out.println(Math.max(dp[0][N][N], Math.max(dp[1][N][N], dp[2][N][N])));
    }


}