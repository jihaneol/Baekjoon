import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int[] dp; // 현재 노드의 서버 정점
    private static List<List<Integer>> tree = new ArrayList<List<Integer>>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree.get(s).add(e);
            tree.get(e).add(s);
        }
        searchTree(r, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(dp[num]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void searchTree(int node, int parent) {

        dp[node] = 1;

        for(int next : tree.get(node)) {
            if(next==parent) continue;
            searchTree(next, node);
            dp[node] += dp[next];
        }
    }


}