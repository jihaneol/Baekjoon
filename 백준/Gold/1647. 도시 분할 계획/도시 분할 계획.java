import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int[] parents;

    private static class Town implements Comparable<Town> {
        int s, e, v;

        Town(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        public int compareTo(Town t){
            return Integer.compare(this.v, t.v);
        }

    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        PriorityQueue<Town> pq = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            pq.add(new Town(s,e,v));
        }

        // n-2 까지
        int cnt = 0;
        int answer = 0;

        while(n-2>cnt){
            Town town = pq.poll();
            if(union(town.s, town.e)){
                cnt++;
                answer += town.v;
            }
        }

        System.out.println(answer);

    }

    public static int find(int x) {
        if (parents[x] == x) return x;

        return parents[x] = find(parents[x]);
    }

    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return false;
        } else {
            parents[x] = y;
            return true;
        }
    }

}