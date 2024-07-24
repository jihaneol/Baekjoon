import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int N, M;
    private static int[] data;
    private static int[][] dp; // i칸일때 j명이 있을때 최소값
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        init();
        solve();
        print();
    }

    private static void print() {
        int ans = INF;
        for(int i=N,j=-1; i>0; i--,j++){
            if(data[N]-data[i]+j>M) break;
            ans = Math.min(dp[N][i],ans);
        }
        System.out.println(ans);
    }

    public static void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        data = new int[N + 1];
        dp = new int[N+1][N + 1];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        for (int i = 0; i <= N; i++)
            dp[i][0] = 0;
        for (int i = 1; i <= N; i++) {
            data[i] += data[i - 1] + sc.nextInt();
        }
    }

    public static void solve() {
        for (int i = 1; i <= N; i++) { // 칸
            for (int j = 1; j <= N; j++) { //사람 수
                for (int k = 0; k < j; k++) {
                    int num = data[j] - data[k] + j - k - 1;
                    if (dp[i - 1][k] == INF) break;
                    if (num > M) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + (M - num) * (M - num));
                }
            }
        }
    }


}