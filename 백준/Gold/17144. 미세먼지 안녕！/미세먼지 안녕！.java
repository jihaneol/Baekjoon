import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int R, C,T, total;
    static int[][] map;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] up = {{-1,0},{0,1},{1,0},{0,-1}};
    static int[][] down = {{1,0},{0,1},{-1,0},{0,-1}};

    static class Dust{
        int x, y,amount;
        Dust(int x, int y, int a){
            this.x = x;
            this.y = y;
            this.amount = a;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        total=2;
        int[][] air = new int[2][2];
        int x =0;
        map = new int[R][C];
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                total+=map[i][j];
                if(map[i][j]==-1){
                    air[x++] = new int[] {i,j};
                }
            }
        }

        while(T-->0){
            spreadDust();
            airWork(air);
        }
        System.out.println(total);
    }

    private static void airWork(int[][] air) {
        //위
        int x = air[0][0];
        int y = air[0][1];
        int dx = x-1;
        int dy = y;
        if(isRange(dx,dy)){
            total-=map[dx][dy];
            map[dx][dy] = 0;
        }
        for(int i=0; i<4; i++){
            while(dx+up[i][0]<=x && dx+up[i][0]>=0 && dy+up[i][1]<C && dy+up[i][1]>=0){
                int nx = dx+up[i][0];
                int ny = dy+up[i][1];
                if(nx==x && ny==y) {
                    map[dx][dy] = 0;
                    break;
                }
                map[dx][dy] = map[nx][ny];
                dx=nx;
                dy=ny;
            }
        }
        //아래
        x = air[1][0];
        y = air[1][1];
        dx = x+1;
        dy = y;
        if(isRange(dx,dy)){
            total-=map[dx][dy];
            map[dx][dy] = 0;
        }
        for(int i=0; i<4; i++){
            while(dx+down[i][0]<R && dx+down[i][0]>=x && dy+down[i][1]<C && dy+down[i][1]>=0){
                int nx = dx+down[i][0];
                int ny = dy+down[i][1];
                if(nx==x && ny==y) {
                    map[dx][dy] = 0;
                    break;
                }
                map[dx][dy] = map[nx][ny];
                dx=nx;
                dy=ny;
            }
        }
    }
    private static void spreadDust() {
        // map 복사
        int[][] tempmap = new int[R][C];
        for(int i=0; i<R; i++)
            tempmap[i] = map[i].clone();
        // 미세 먼지 확산
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(map[r][c]<5) continue;
                int count = 0;
                for(int i=0; i<4; i++){
                    int nx = r+dir[i][0];
                    int ny = c+dir[i][1];
                    if(!isRange(nx,ny) || map[nx][ny]==-1) continue;
                    tempmap[nx][ny]+= map[r][c]/5;
                    count++;
                }
                tempmap[r][c] -= (map[r][c]/5 * count);
            }
        }
        map = tempmap;
    }
    private static boolean isRange(int x, int y ){
        return x<R && x>=0 && y<C && y>=0;
    }
}