import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M;

    static int[] in;

    static List<List<Integer>> graph;

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        in = new int[N + 1];
        graph = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int[] temp = new int[K];
            for (int j = 0; j < K; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < K - 1; j++) {
                graph.get(temp[j]).add(temp[j + 1]);
                in[temp[j + 1]]++;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (in[i] == 0) {
                q.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            cnt++;
            sb.append(now).append('\n');
            for (int e : graph.get(now)) {
                in[e]--;
                if(in[e]==0){
                    q.add(e);
                }
            }
        }
        
        if(cnt==N){
            System.out.println(sb);
        }else{
            System.out.println(0);
        }

    }


}