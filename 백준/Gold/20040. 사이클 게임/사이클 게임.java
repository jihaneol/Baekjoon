import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
        List<Node> LineList = new ArrayList<>();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            LineList.add(new Node(s,e));
        }

        int cnt = 0;
        int answer = 0;
        for(Node node : LineList){
            cnt++;
            if(!union(node)){
                answer = cnt;
                break;
            }
        }

        System.out.println(answer);



    }

    private static boolean union(Node node) {
        int x = find(node.x);
        int y = find(node.y);

        if(x==y){
            return false;
        }else{
            parents[x] = y;
            return true;
        }
    }

    private static int find(int x) {
        if(x==parents[x]) return x;
        return parents[x] = find(parents[x]);
    }


}