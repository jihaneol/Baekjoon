import java.io.*;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        boolean[][] dp = new boolean[n+1][n+1]; //1차원 시작 2차원 끝 위치
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp 초기화
        palindrome(arr,dp);

        int t = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        while(t-->0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(dp[s][e]?1:0).append("\n");
        }

        System.out.println(sb.toString());

    }

    private static void palindrome(int[] arr, boolean[][] dp) {
        for(int i=1; i<=n; i++){
            dp[i][i] = true;
        }

        for(int i=1; i<=n-1; i++){
            if(arr[i] == arr[i+1]) dp[i][i+1] = true;
        }

        for(int i=2; i<n; i++){
            for(int j=1; j+i<=n; j++){
                if(arr[j] == arr[j+i] && dp[j+1][j+i-1]) dp[j][j+i] = true;
            }
        }
    }
}