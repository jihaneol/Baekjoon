import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dp = new int[N+1];
        int[][] pip = new int[M][2];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            pip[i][0] = Integer.parseInt(st.nextToken());
            pip[i][1] = Integer.parseInt(st.nextToken());
        }
        dp[0] = Integer.MAX_VALUE;
        for(int i=0; i<M; i++){
            for(int j=N; j>=pip[i][0]; j--){
                dp[j] = Math.max(dp[j],Math.min(dp[j-pip[i][0]],pip[i][1]));
            }
        }
        System.out.println(dp[N]);
    }
}