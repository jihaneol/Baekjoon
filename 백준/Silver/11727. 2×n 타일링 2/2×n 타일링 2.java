import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        /**
         * 2*N
         * 1*2, 2*2, 2*1
         * 1 일때  1가지
         * 2 일때  1가지 + 1가지 + 1가지
         * 3 일때  1가지 + 1가지 + 1가지
         * 4 일때
         */
        int N  = sc.nextInt();

        int[] dp = new int[N+2];
        dp[1] = 1;
        dp[2] = 3;

        for(int i=3; i<=N; i++){
          dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
        }
        System.out.println(dp[N]);
    }
}
