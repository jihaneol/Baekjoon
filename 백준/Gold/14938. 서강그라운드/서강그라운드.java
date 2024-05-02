import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, r;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        int[] item = new int[n+1];
        int[][] arr = new int[n+1][n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            item[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(arr[i], m+1);
            arr[i][i] = 0;
        }

        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[s][e] = v;
            arr[e][s] = v;
        }
   
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
        int answer = 0;
        for(int i=1; i<=n; i++){
            int total = 0;
            for(int j=1; j<=n; j++){
                if(arr[i][j]<=m) total+= item[j];
            }
            answer = Math.max(answer,total);
        }

        System.out.println(answer);

    }
}