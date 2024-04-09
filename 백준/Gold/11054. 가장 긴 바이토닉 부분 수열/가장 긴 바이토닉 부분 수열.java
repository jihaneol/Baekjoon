import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.valueOf(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }
        int[] lisDP = LIS();
        int[] ldsDP = LDS();
        int answer = 0;
        for(int i=0; i<N; i++){
            answer = Math.max(lisDP[i]+ldsDP[i]-1,answer);
        }
        System.out.println(answer);

    }

    public static int[] LIS() {
        int[] dp = new int[N];
        for (int i = 0; i<N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp;
    }

    public static int[] LDS() {
        int[] dp = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp;
    }


}