import java.util.Scanner;

public class Main {
    private static int N, M;
    private static int[] data;
    private static int[][] dp;
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        init();
        solution();
        print();
    }

    private static void print() {
        System.out.println(dp[3][N]);
    }

    public static void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        data = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            data[i] = data[i - 1] + sc.nextInt();
        }
        M = sc.nextInt();
        dp = new int[4][N+1];
    }

    public static void solution() {
        for(int i=1; i<4; i++){
            for(int j=i*M; j<=N; j++){
                dp[i][j] = Math.max(dp[i][j-1],
                        dp[i-1][j-M]+data[j]-data[j-M]);
            }
        }
    }
}