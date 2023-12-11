
import java.io.*;
import java.util.*;

public class Main {
    private static char[][] map;
    private static int ans = 0;
    private static int N,M;
    private static   int[] dx = {-1 ,0 ,1};
    private static  int[] dy = { 1 ,1 ,1};
    public static void main(String[] args) throws Exception{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        map = new char[N][];

        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<N; i++){
            if(connect(i, 0)) ans++;
        }

        System.out.println(ans);

    }

    private static boolean connect(int x, int y) {
        map[x][y] = 'x';

        if(y == M-1){
            return true;
        }
        for(int i=0; i<3; i++){
            int nx = dx[i] +x;
            int ny = dy[i] +y;
            if(isRange(nx,ny) && map[nx][ny] == '.' && connect(nx,ny)){
                return true;
            }
        }
        return false;
    }

    private static boolean isRange(int nx, int ny) {
        if(nx>=0 && ny>=0 && nx<N && ny<M) return true;
        return false;
    }


}











