import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int answer = 0;
        int max = 0;
        int[] dp = new int[N+2];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.valueOf(st.nextToken());
            int p = Integer.valueOf(st.nextToken());
            max = Math.max(max,dp[i]);
            if(t+i<=N+1){
                dp[t+i] = Math.max(dp[t+i],max+p);

            }
        }
        System.out.println(Math.max(max,dp[N+1]));

    }

}