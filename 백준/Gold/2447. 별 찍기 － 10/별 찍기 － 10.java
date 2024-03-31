import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        map = new char[n][n];
        for(int i=0; i<n; i++) Arrays.fill(map[i],' ');

        star(0,0,n);
        StringBuilder sb =new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
    public static void star(int r, int c, int n){
        if(n==3){
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    map[r + i][c + j] = '*';
                }
            }
            map[r+1][c+1] = ' ';
        }else{
            int offset = n/3;
            for(int i=0; i<n; i+=offset){
                for(int j=0; j<n; j+=offset){
                    if(i==offset && j==offset) continue;
                    star(r+i,c+j, offset);
                }
            }
        }
    }

}
