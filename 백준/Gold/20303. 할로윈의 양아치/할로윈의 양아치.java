import java.io.*;
import java.util.*;


public class Main {
    static int[] parents, candy;

    static class Idle {
        int value, num;

        Idle(int v, int n) {
            value = v;
            num = n;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        candy = new int[N + 1];

        Map<Integer, Idle> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        for(int i=1; i<=N; i++){
            int p = find(i);
            if(!map.containsKey(p)){
                map.put(p,new Idle(candy[i],1));
            }else{
                Idle idle = map.get(p);
                idle.value+=candy[i];
                idle.num+=1;
            }
        }

        int[] dp = new int[K];
        for(int i:map.keySet()){
            Idle now = map.get(i);
            for(int j=0;j+now.num<K; j++){
                dp[j] = Math.max(dp[j],dp[j+now.num]+now.value);
            }
        }
        System.out.println(dp[0]);
    }

    public static int find(int a) {
        if (parents[a] == a) return a;

        return parents[a] = find(parents[a]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) parents[a] = b;

    }
}