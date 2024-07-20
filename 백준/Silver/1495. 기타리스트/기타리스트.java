import java.util.Scanner;

public class Main {
    private static int N,S,M,ans;
    private static int[] V;
    private static boolean[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        M = sc.nextInt();
        V= new int[N];
        for(int i=0; i<N; i++){
            V[i] = sc.nextInt();
        }
        dp = new boolean[N+1][M+1];

        play(0,S);
        ans = -1;
        for(int i=0; i<=M; i++){
            if(dp[N][i]){
                ans = i;
            }
        }
        System.out.println(ans);
    }
    public static void play(int start, int volume){
        if(start==N) {
            dp[start][volume] = true;
            return;
        }
        if(dp[start][volume]) return;
        dp[start][volume] = true;

        if(volume+V[start]<=M){
          play(start+1, volume+V[start]);
        }

        if(volume-V[start]>=0){
            play(start+1, volume-V[start]);
        }

    }
}