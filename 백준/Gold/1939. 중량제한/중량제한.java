import java.io.*;
import java.util.*;

public class Main {
    private static boolean[] visited;
    private static List<List<City>> land ;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        land = new ArrayList<>();
        for(int i=0; i<=n; i++){
            land.add(new ArrayList<>());
        }
        int left = 0;
        int right = 1_000_000_000;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            land.get(a).add(new City(b,c));
            land.get(b).add(new City(a,c));
        }
        st = new StringTokenizer(br.readLine());
        int to = Integer.parseInt(st.nextToken());
        int from = Integer.parseInt(st.nextToken());
        int ans = 0;
        while(left<=right){
            int mid = (right+left)/2;
            visited = new boolean[n+1];
            if(dfs(to, from, mid)){
                ans = mid;
                left = mid +1;
            }else{
                right = mid-1;
            }
        }

        System.out.println(ans);

    }
    public static boolean dfs(int pos, int target, int limit){
        if(pos==target){
            return true;
        }
        visited[pos] = true;

        for(City c : land.get(pos)){
            if(!visited[c.to] && limit <= c.w){
                if(dfs(c.to, target, limit)){
                    return true;
                }
            }
        }
        return false;
    }

    private static class City {
        int to,w;
        City(int n, int w){
            this.to = n;
            this.w = w;
        }
    }
}