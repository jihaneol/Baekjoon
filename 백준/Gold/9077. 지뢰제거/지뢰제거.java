

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int test = Integer.valueOf(br.readLine());
        while(test-->0){
            int max = 1;
            short[][] map = new short[10001][10001];
            int N = Integer.valueOf(br.readLine());
            for(int i = 0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.valueOf(st.nextToken());
                int y = Integer.valueOf(st.nextToken());

                max = boom_checker(max,map,x,y);
            }


            System.out.println(max);

        }
    }
    public static int boom_checker(int max, short[][] map, int x, int y){
        for(int i = x-5; i<=x+5; i++){
            for(int j = y-5; j<=y+5; j++){
                if(range_checker(i,j)){
                    map[i][j] +=1;
                    if(max<map[i][j]){
                        max = map[i][j];
                    }
                }
            }
        }
        return max;
    }
    public static boolean range_checker(int x, int y){
       if(x>=0 && y>=0 && x<10001 && y<10001) {
           return true;
       }
       return false;
    }


}
