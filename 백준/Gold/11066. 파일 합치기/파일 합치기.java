import java.util.Scanner;

public class Main {
    static int dp[][];
    static int sum[];
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            dp = new int[n + 1][n + 1];
            sum = new int[n + 1];
            for (int i = 1; i <=n; i++) {
                sum[i] = sum[i - 1] +  scanner.nextInt();
            }


            for (int k = 1; k <= n; k++) {
                for (int s = 1; s + k <= n; s++) {
                    int e = s + k;
                    dp[s][e] = 214748364;
                    for (int m = s; m < e; m++) {
                        dp[s][e] = Math.min(dp[s][e],
                                dp[s][m] + dp[m + 1][e] + sum[e] - sum[s - 1]);
                    }
                }
            }
            System.out.println(dp[1][n]);
        }
    }


}