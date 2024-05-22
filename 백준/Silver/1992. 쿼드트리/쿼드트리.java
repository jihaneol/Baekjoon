import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static int[][] map;
    public static void main (String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i=0; i<N; i++){
            String[] split = br.readLine().split("");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        compress(N, 0 , 0);
    }

    public static void compress(int N, int x, int y){
        if(N==1){
            System.out.print(map[x][y]);
            return;
        }
        int target = map[x][y];
        boolean flag = true;
        out : for(int i=x; i<x+N; i++){
            for(int j=y; j<y+N; j++){
                if(target!=map[i][j]){
                    flag = false;
                    break out;
                }
            }

        }

        if(flag) {
            System.out.print(target);
        }
        else{
            N /= 2;
            System.out.print('(');
            compress(N, x, y);
            compress(N, x, y+N);
            compress(N, x+N, y);
            compress(N, x+N, y+N);
            System.out.print(')');
        }
    }

}