import java.io.*;
import java.util.*;


public class Main {
    static int[][] map;
    static int N, count, nowR, nowC, nowD, move, answer;

    static int[][] dir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = nowD = answer = 0;
        nowR = nowC = N / 2 +1;
        move = 1;

        while (N * N > count) {
            for(int i=0; i<move; i++){
                nowR = nowR + dir[nowD][0];
                nowC = nowC + dir[nowD][1];
                if(map[nowR][nowC]==0) continue;
                game();
            }
                count+=move;
                if(nowD==1 || nowD==3) move++;
                nowD = (nowD+1)%4;

        }

        System.out.println(answer);

    }

    public static void game(){
        int up = nowD-1==-1?3:nowD-1;
        int down = (nowD+1)%4;
        int back = (nowD+2)%4;
        int go = nowD;
        int sum = 0;
        int center = map[nowR][nowC];
        //7%
        sum+=calcu( nowR + dir[up][0],nowC + dir[up][1],7,center);
        sum+=calcu( nowR + dir[down][0],nowC + dir[down][1],7,center);
        //1%
        sum+=calcu( nowR + dir[up][0]+dir[back][0],nowC + dir[up][1]+dir[back][1],1,center);
        sum+=calcu( nowR + dir[down][0]+dir[back][0],nowC + dir[down][1]+dir[back][1],1,center);
        //10%
        sum+=calcu( nowR + dir[up][0]+dir[go][0],nowC + dir[up][1]+dir[go][1],10,center);
        sum+=calcu( nowR + dir[down][0]+dir[go][0],nowC + dir[down][1]+dir[go][1],10,center);
        // 2%
        sum+=calcu( nowR + dir[up][0]*2,nowC + dir[up][1]*2,2,center);
        sum+=calcu( nowR + dir[down][0]*2,nowC + dir[down][1]*2,2,center);
        // 5%
        sum+=calcu( nowR + dir[go][0]*2,nowC + dir[go][1]*2,5,center);
        // 알파
        int nx = nowR+ dir[go][0];
        int ny = nowC+ dir[go][1];
        if(nx<=0 || ny<=0 || nx>=N+1 || ny>=N+1){
            answer+= center-sum;
        }else{
            map[nx][ny] += center-sum;
        }
        map[nowR][nowC] = 0;
    }
    public static int calcu(int nx, int ny, int percent, int center){
        int num = center * percent / 100;
        if(nx<=0 || ny<=0 || nx>=N+1 || ny>=N+1){
            answer+=num;
        }else{
            map[nx][ny] += num;
        }
        return num;
    }

}