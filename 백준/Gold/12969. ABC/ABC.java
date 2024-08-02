import java.util.Scanner;
public class Main{
    private static int N, K;
    private static boolean[][][][] dp;

    public static void main(String[] args) {
        init();
        dfs("", 0, 0, 0,0);
        System.out.println(-1);
    }

    public static void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        dp = new boolean[N + 1][N+1][N+1][N*(N-1)/2+1];

    }

    public static void dfs(String sb, int len, int a, int b, int cnt) {

        if(len==N){
            if(cnt==K){
                System.out.println(sb);
                System.exit(0);
            }
            return;
        }

        if(dp[len][a][b][cnt]) return;
        dp[len][a][b][cnt] = true;

        dfs(sb+'A',len+1, a+1, b, cnt);
        dfs(sb+'B',len+1, a, b+1, cnt+a);
        dfs(sb+'C',len+1, a, b, cnt+a+b);

    }
}