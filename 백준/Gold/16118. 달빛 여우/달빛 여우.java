import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int idx;
        long cost;
        int state; // 0: 빠름, 1: 느림 (for 늑대)

        Node(int idx, long cost, int state) {
            this.idx = idx;
            this.cost = cost;
            this.state = state;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    static final long INF = Long.MAX_VALUE;
    static ArrayList<Node>[] graph;
    static long[] foxDist;
    static long[][] wolfDist;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) * 2; 
            graph[a].add(new Node(b, d, 0));
            graph[b].add(new Node(a, d, 0));
        }

        foxDist = new long[N + 1];
        wolfDist = new long[N + 1][2];

        Arrays.fill(foxDist, INF);
        for (int i = 1; i <= N; i++) Arrays.fill(wolfDist[i], INF);

        dijkstraFox();
        dijkstraWolf();

        int answer = 0;
        for (int i = 2; i <= N; i++) {
            long wolfMin = Math.min(wolfDist[i][0], wolfDist[i][1]);
            if (foxDist[i] < wolfMin) answer++;
        }
        System.out.println(answer);
    }

    static void dijkstraFox() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        foxDist[1] = 0;
        pq.offer(new Node(1, 0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (foxDist[cur.idx] < cur.cost) continue;
            for (Node next : graph[cur.idx]) {
                if (foxDist[next.idx] > cur.cost + next.cost) {
                    foxDist[next.idx] = cur.cost + next.cost;
                    pq.offer(new Node(next.idx, foxDist[next.idx], 0));
                }
            }
        }
    }

    static void dijkstraWolf() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        wolfDist[1][0] = 0;
        pq.offer(new Node(1, 0, 0)); 

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (wolfDist[cur.idx][cur.state] < cur.cost) continue;
            for (Node next : graph[cur.idx]) {
                int nextState = (cur.state == 0) ? 1 : 0;
                long nextCost = (cur.state == 0) ? cur.cost + next.cost / 2 : cur.cost + next.cost * 2;
                if (wolfDist[next.idx][nextState] > nextCost) {
                    wolfDist[next.idx][nextState] = nextCost;
                    pq.offer(new Node(next.idx, nextCost, nextState));
                }
            }
        }
    }
}