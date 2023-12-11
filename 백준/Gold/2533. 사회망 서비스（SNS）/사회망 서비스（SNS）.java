import java.io.*;
import java.util.*;
public class Main {
    private static List<Integer>[] tree;
    private static int N;
    private static int[][] dp;
    private static boolean[] visited;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());

        tree = new List[N + 1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        dp = new int[N + 1][2]; //1 얼리어답터, 0 노얼리어답터

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.valueOf(st.nextToken());
            int e = Integer.valueOf(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0],dp[1][1]));
    }

    private static void dfs(int start) {
        visited[start] = true;
        dp[start][0] = 0;
        dp[start][1] = 1;
        for (int next : tree[start]) {
            if(visited[next]) continue;
            dfs(next);
            dp[start][1] += Math.min(dp[next][0],dp[next][1]);
            dp[start][0] += dp[next][1];

        }
    }
}