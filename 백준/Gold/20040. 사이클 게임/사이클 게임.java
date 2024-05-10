import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;

    static int[] parents;
    static class Node{
        int x,y;
        Node(int s, int e){
            this.x = s;
            this.y = e;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n];

        for(int i=0; i<n; i++){
            parents[i] = i;
        }
        int answer =0;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(!union(s,e)){
                answer = i+1;
                break;
            }
        }




        System.out.println(answer);



    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x==y){
            return false;
        }else{
            if(x<y) parents[y] = x;
            else parents[x] = y;
            return true;
        }
    }

    private static int find(int x) {
        if(x==parents[x]) return x;
        return parents[x] = find(parents[x]);
    }


}