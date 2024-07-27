import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int N, M;
    private static int[] data;
    private static int[][] dp;
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        init();
        print();
    }

    private static void print() {
        System.out.println(solution(0,0));
    }

    public static void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = sc.nextInt();
        }
        dp = new int[N + 1][M + 2];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
    }

    public static int solution(int idx, int cnt) {
        // 마지막 사람
        if (idx == N) return 0;
        if (dp[idx][cnt] != -1) return dp[idx][cnt];
        int left = M - cnt + 1;
        // 다음 칸
        dp[idx][cnt] = solution(idx + 1, data[idx] + 1) + left * left;
        // 이번 칸
        if (cnt + data[idx] <= M)
            dp[idx][cnt] = Math.min(solution(idx + 1, cnt + data[idx]+1),
                    dp[idx][cnt]);

        return dp[idx][cnt];
    }
}