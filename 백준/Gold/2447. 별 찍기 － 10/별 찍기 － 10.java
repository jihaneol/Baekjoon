import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        map = new char[n][n];
        for(int i=0; i<n; i++) Arrays.fill(map[i],' ');
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        star(0,0,n);;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                bw.write(map[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
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
            for(int i=r; i<n+r; i+=offset){
                for(int j=c; j<n+c; j+=offset){
                    if(i==r+offset && j==c+offset) continue;
                    star(i,j, offset);
                }
            }
        }
    }

}