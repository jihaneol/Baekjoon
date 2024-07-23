import java.util.*;
public class Main {
    private static int N;
    private static  char[] data;
    private static  int[] dp;
    private static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        init();
        solve();
    }

    public static void init(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        data = sc.next().toCharArray();

        dp = new int[N];
        Arrays.fill(dp,INF);
    }
    public static void solve(){
       dp[0] = 0;
       for(int i=0; i<N; i++){
           for(int j=1; j<=i; j++){
               if(dp[i-j]!=INF && data[i-j]==chage(data[i])){
                   dp[i] = Math.min(dp[i],dp[i-j]+j*j);
               }
           }
       }

        System.out.println(dp[N-1]==INF?-1:dp[N-1]);
    }

    private static char chage(char c) {
        switch (c) {
            case 'B':
                return 'J';
            case 'O':
                return 'B';
        }
        return 'O';
    }

}