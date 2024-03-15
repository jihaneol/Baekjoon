import java.io.*;
import java.util.*;


public class Main {
    static int n,m,r,answer;
    static boolean[][] visited;
    static int[][] map;
    static int[][] dir = {{0,-1},{1,0},{0,1},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        answer =0;
        visited = new boolean[n+1][m+1];
        map = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = r*2;
        for(int i=0; i<cnt; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(i%2==0) {
                int d = direction(st.nextToken());
                attack(x,y,d);
            }else{
                visited[x][y] = false;
            }

        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(visited[i][j]) sb.append('F').append(" ");
                else sb.append('S').append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void attack(int x, int y, int d) {
        if(visited[x][y]) return ;
        answer++;
        visited[x][y] = true;
        int cnt = map[x][y];

        for(int i=0; i<cnt-1; i++){
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];
            if(!isRange(nx,ny)) break;
            attack(nx,ny,d);

            x = nx;
            y = ny;
        }
    }
    private static boolean isRange(int x, int y){
        return x>0 && y>0 && x<=n && y<=m;
    }

    private static int direction(String d){
        int result = 0;
        switch (d) {
            case "E" :
                result = 2;
                break;
            case "N" :
                result = 3;
                break;
            case  "S" :
                result = 1;
        }
        return result;
    }

}