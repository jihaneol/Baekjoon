import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        int[][] dp = new int[10001][4];

        for(int i=1; i<4; i++){
            for(int j=1; j<=i; j++){
                dp[i][j] = 1;
            }
        }

        for(int i=4; i<10001; i++){
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][2] + dp[i-2][1];
            dp[i][3] = dp[i-3][1]+dp[i-3][2]+dp[i-3][3];
        }

        while(t-->0){
            int n = sc.nextInt();

            System.out.println(dp[n][1]+dp[n][2]+dp[n][3]);

        }
    }
}