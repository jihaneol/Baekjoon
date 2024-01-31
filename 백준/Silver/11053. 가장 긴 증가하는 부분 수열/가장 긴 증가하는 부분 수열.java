
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
//        Scanner sc = new Scanner(System.in);
//        StringBuilder sb = new StringBuilder();
//        Formatter f = new Formatter(sb);
        int N = Integer.valueOf(br.readLine());
        int dp[][] = new int[N+1][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            dp[i][0] = Integer.valueOf(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < N+1 ; i++) {
            for (int j = 0; j < i; j++){
                if(dp[i][0]>dp[j][0]){
                    dp[i][1] = Math.max(dp[j][1]+1,dp[i][1]);
                }
            }
        }
        for(int i=1; i<N+1; i++){
            if(answer<dp[i][1]){
                answer = dp[i][1];
            }
        }
        System.out.println(answer);

    }

}