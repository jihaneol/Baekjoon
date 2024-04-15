import java.util.*;

public class Main {
    static List<List<Edge>> graph = new ArrayList<>();
    static boolean[] visited;
    static class Edge implements Comparable<Edge> {
        int node, value;
        Edge(int n, int v) {
            this.node = n;
            this.value = v;
        }
        public int compareTo(Edge e) {
            return Integer.compare(this.value,e.value);
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        visited = new boolean[n+1];
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            int v = sc.nextInt();
            graph.get(s).add(new Edge(e,v));
            graph.get(e).add(new Edge(s,v));
        }

        prime(1);
    }
    public static void prime(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start,0));
        int val = 0;
        while(!pq.isEmpty()){
            Edge now = pq.poll();

            if(visited[now.node]) continue;
            visited[now.node] = true;

            val += now.value;

            for(Edge next : graph.get(now.node)){
                if(!visited[next.node]){
                    pq.add(next);
                }
            }
        }
        System.out.println(val);

    }

}
