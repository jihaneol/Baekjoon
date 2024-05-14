import java.io.*;
import java.util.*;

public class Main {
    static int[] team;
    static boolean[] visited, done;
    static int res;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        while(T-->0){

            int N = Integer.parseInt(br.readLine());
            team = new int[N+1];
            visited = new boolean[N + 1];
            done = new boolean[N+1];
            st = new StringTokenizer(br.readLine());

            for(int i=1; i<=N; i++) {
                team[i] = Integer.parseInt(st.nextToken());
            }

            res = 0;
            for(int i=1; i<=N; i++){
                if(!done[i]){
                    dfs(i);
                }
            }

            sb.append(N-res).append('\n');


        }

        System.out.println(sb.toString());

    }

    private static void dfs(int now) {
       if(done[now]) return;

       if(visited[now]){
           res++;
           done[now] = true;
       }
       visited[now] = true;

       dfs(team[now]);
  
       done[now] = true;

    }
}