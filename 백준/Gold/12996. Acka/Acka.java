import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][][][] dp = new int[S + 1][A + 1][B + 1][C + 1];
        dp[0][A][B][C] = 1;
        int mod = 1000000007;

        for (int s = 0; s < S; s++) {
            for (int a = 0; a <= A; a++) {
                for (int b = 0; b <= B; b++) {
                    for (int c = 0; c <= C; c++) {
                        if (dp[s][a][b][c] == 0)
                            continue;
                        if (a != 0)
                            dp[s + 1][a - 1][b][c] = (dp[s + 1][a - 1][b][c] + dp[s][a][b][c]) % mod;
                        if (b != 0)
                            dp[s + 1][a][b - 1][c] = (dp[s + 1][a][b - 1][c] + dp[s][a][b][c]) % mod;
                        if (c != 0)
                            dp[s + 1][a][b][c - 1] = (dp[s + 1][a][b][c - 1] + dp[s][a][b][c]) % mod;
                        if (a != 0 && b != 0)
                            dp[s + 1][a - 1][b - 1][c] = (dp[s + 1][a - 1][b - 1][c] + dp[s][a][b][c]) % mod;
                        if (a != 0 && c != 0)
                            dp[s + 1][a - 1][b][c - 1] = (dp[s + 1][a - 1][b][c - 1] + dp[s][a][b][c]) % mod;
                        if (b != 0 && c != 0)
                            dp[s + 1][a][b - 1][c - 1] = (dp[s + 1][a][b - 1][c - 1] + dp[s][a][b][c]) % mod;
                        if (a != 0 && b != 0 && c != 0)
                            dp[s + 1][a - 1][b - 1][c - 1] = (dp[s + 1][a - 1][b - 1][c - 1] + dp[s][a][b][c]) % mod;
                    }
                }
            }
        }

        bw.write(String.valueOf(dp[S][0][0][0]));
        bw.flush();
    }

}