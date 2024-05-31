import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        map = new int[9][9];

        for (int i = 0; i < 9; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                map[i][j] = c[j]-'0';
            }
        }
        fillMap(0,0,0,0);

    }

    private static void fillMap(int r, int c, int x, int y) {
        int now = map[r][c];

        if (now == 0) {
            boolean visited[] = new boolean[9];
            int temp;
            // 행 열 구하기
            for(int i=0; i<9; i++){
                temp = map[r][i];
                if(temp!=0){
                    visited[temp-1] = true;
                }

                temp = map[i][c];
                if(temp!=0){
                    visited[temp-1] = true;
                }
            }
            // 9자리 확인
            for(int i=x; i<x+3; i++){
                for(int j=y; j<y+3; j++){
                    if(map[i][j]!=0){
                        visited[map[i][j]-1] = true;
                    }
                }
            }
            // 후보군 보기
            for(int i=0; i<9; i++){
                if(!visited[i]){
                    map[r][c] = i+1;
                    fillMap(r,c,x,y);
                    map[r][c] = 0;
                }
            }

        } else {
            if (c < 8) {
                if (c % 3 == 2)
                    fillMap(r, c + 1, x, y + 3);
                else
                    fillMap(r, c + 1, x, y);
            } else {
                if (r < 8) {
                    if (r % 3 == 2)
                        fillMap(r + 1, 0, x + 3, 0);
                    else
                        fillMap(r + 1, 0, x, 0);
                }else{
                    for(int i=0; i<9; i++){
                        for(int j=0; j<9; j++){
                            System.out.print(map[i][j]);
                        }
                        System.out.println();
                    }
                    System.exit(0);
                }
            }

        }


    }
}
