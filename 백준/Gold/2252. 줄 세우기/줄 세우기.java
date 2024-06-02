import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] in = new int[N + 1];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st =  new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            in[b]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=N; i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now).append(' ');

            for(int next : graph.get(now)){
                in[next]--;
                if(in[next]==0){
                    q.add(next);
                }
            }

        }

        System.out.println(sb.toString());

    }
}