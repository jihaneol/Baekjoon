import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.valueOf(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }

        int[] dp = new int[N];
        for(int i=N-1; i>=0; i--){
            dp[i] = 1;
            for(int j=N-1; j>i; j--){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
        }
        int answer = 0;
        for(int i=0; i<N; i++){
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }

}