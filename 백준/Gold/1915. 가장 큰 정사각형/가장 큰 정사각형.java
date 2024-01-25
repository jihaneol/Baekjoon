import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][] arr = new int[N+1][M+1];
        int [][] dp = new int[N+1][M+1];

        for(int i=1; i<=N; i++){

            String temp = br.readLine();
            for(int j=1; j<=M; j++){
                arr[i][j] = temp.charAt(j-1) - '0';
            }
        }
        int answer = 0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(arr[i][j]==0) continue;
                dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;

                answer = Math.max(answer,dp[i][j]);
            }
        }

        System.out.println(answer*answer);

    }
}