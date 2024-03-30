import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        map = new char[n][2*n-1];
        for(int i=0; i<n; i++) Arrays.fill(map[i],' ');

        star(0,n-1,n);
        StringBuilder sb =new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<2*n-1; j++){
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
    public static void star(int r, int c, int n){
        if(n==3){
            map[r][c] = '*';
            map[r+1][c-1] = map[r+1][c+1] = '*';
            for(int i=0; i<5; i++){
                map[r+2][c-2+i] = '*';
            }
            return;
        }else{
            int offset = n/2;
            star(r,c, offset);
            star(r+offset,c-offset,offset);
            star(r+offset,c+offset,offset);
        }
    }

}
