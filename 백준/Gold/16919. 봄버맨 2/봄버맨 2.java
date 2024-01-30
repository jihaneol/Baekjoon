import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int r,c,n;
    private static char[][][] map;

    private static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] s = br.readLine().split(" ");
        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        n = Integer.parseInt(s[2]);
        StringBuilder sb = new StringBuilder();

        map = new char[r][c][3]; //1초뒤 3초뒤 5초뒤

        // 초기
        for(int i=0; i<r; i++){
            char[] charArray = br.readLine().toCharArray();
            for(int j=0; j<c; j++){
                map[i][j][0] = charArray[j];
                map[i][j][1] = 'O';
                map[i][j][2] = 'O';
            }
        }
       
       
        if(n==1){
            print(sb,0);
        }else{
            int answer = n%4==1 ? 2: n%4==3 ? 1 : 0;
            if(answer == 0) {
               printFullBoom(sb);
            }else if(answer ==1 ){
                nextBoom(0,1);
                print(sb,answer);
            }else{
                nextBoom(0,1);
                nextBoom(1,2);
                print(sb,answer);
            }
        }

    }
    public static void printFullBoom(StringBuilder sb){
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                sb.append('O');
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void print(StringBuilder sb, int num){
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                sb.append(map[i][j][num]);
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void nextBoom(int v1, int v2){ //초기, 다음

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(map[i][j][v1] == 'O'){
                    map[i][j][v2] = '.';
                    for(int idx=0; idx<4; idx++){
                        int dx = i + dir[idx][0];
                        int dy = j + dir[idx][1];
                        if(dx<0 || dx>=r || dy<0 || dy>=c) continue;
                        map[dx][dy][v2] = '.';
                    }
                }
            }
        }
    }
}