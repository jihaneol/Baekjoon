import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, k;

    static int[] buildTime, dp;

    static boolean visited[];

    static List<List<Integer>> buildGraph;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            buildGraph = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            buildTime = new int[n + 1];
            dp = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            buildGraph.add(new ArrayList<>());
            for (int i = 1; i <= n; i++) {

                buildGraph.add(new ArrayList<>());
                buildTime[i] = Integer.parseInt(st.nextToken());

            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                buildGraph.get(y).add(x);
            }

            int w = Integer.parseInt(br.readLine());

            visited = new boolean[n + 1];
            build(w);

            System.out.println(dp[w]);

        }
    }

    public static void build(int start) {

        boolean isleaf = true;

        for (int next : buildGraph.get(start)) {
            isleaf = false;
            if (!visited[next]) {
                visited[next] = true;
                build(next);
            }
            dp[start] = Math.max(dp[start], buildTime[start] + dp[next]);
        }
        if (isleaf) {
            dp[start] = buildTime[start];
        }
    }

}