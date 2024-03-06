import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][3];
        int[][] dpMax = new int[N][3];
        int[][] dpMin = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            dpMax[0][i] = map[0][i];
            dpMin[0][i] = map[0][i];
        }

        for (int i = 0; i < N - 1; i++) {
           dpMax[i+1][0] = Math.max(dpMax[i][0],dpMax[i][1]) +map[i+1][0];
           dpMax[i+1][1] = Math.max(dpMax[i][2],Math.max(dpMax[i][0],dpMax[i][1])) +map[i+1][1];
           dpMax[i+1][2] = Math.max(dpMax[i][2],dpMax[i][1]) +map[i+1][2];

            dpMin[i+1][0] = Math.min(dpMin[i][0],dpMin[i][1]) +map[i+1][0];
            dpMin[i+1][1] = Math.min(dpMin[i][2],Math.min(dpMin[i][0],dpMin[i][1])) +map[i+1][1];
            dpMin[i+1][2] = Math.min(dpMin[i][2],dpMin[i][1]) +map[i+1][2];
        }
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i=0; i<3; i++){
            min = Math.min(min,dpMin[N-1][i]);
            max = Math.max(max,dpMax[N-1][i]);
        }

        System.out.println(max+" "+min);

    }
}