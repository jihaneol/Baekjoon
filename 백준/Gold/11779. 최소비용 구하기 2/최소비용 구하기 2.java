import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;

    static int[] dist;
    static PriorityQueue<Bus> pq = new PriorityQueue<>();

    static List<List<Bus>> graph = new ArrayList<>();

    static class Bus implements Comparable<Bus>{
        int node, value;

        Bus(int n, int v){
            node = n;
            value = v;
        }
        public int compareTo(Bus b){
            return Integer.compare(value, b.value);
        }
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Bus(e,v));
        }

        dist = new int[n+1];

        Arrays.fill(dist, 100000001);
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dist[start] = 0;

        pq.add(new Bus(start,0));

        int minimum_cost = 0;
        int[] preCity = new int[n+1];
        while(!pq.isEmpty()){
            Bus now = pq.poll();
            if(now.value > dist[now.node]) continue;

            if(now.node == end){
                minimum_cost = dist[now.node];
                break;
            }

            for(Bus next : graph.get(now.node)){
                if(dist[next.node] > dist[now.node] + next.value){
                    dist[next.node] = dist[now.node]  + next.value;
                    preCity[next.node] = now.node;
                    pq.add(new Bus(next.node, now.value+next.value));
                }
            }
        }
        System.out.println(minimum_cost);
        int cnt = 1;

        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        while(preCity[end]!=0){
            cnt++;
            end = preCity[end];
            stack.push(end);
        }

        System.out.println(cnt);

        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }



    }
}