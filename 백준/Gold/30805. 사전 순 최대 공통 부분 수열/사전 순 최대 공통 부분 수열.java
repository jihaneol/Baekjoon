import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int index_A = 0;
        int index_B = 0;
        int top = 0;
        int top_x = 0;
        int top_y = 0;
        int result = 0;
        StringBuilder sb = new StringBuilder();
        while (index_A < n && index_B < m) {
            top = 0;
            for (int i = index_A; i < n; i++) {
                for (int j = index_B; j < m; j++) {
                    if (A[i] == B[j]) {
                        if (top < A[i]) {
                            top = A[i];
                            top_x = i;
                            top_y = j;
                            break;
                        }
                    }
                }
            }
            if (top != 0) {
                result++;
                index_A = top_x + 1;
                index_B = top_y + 1;
                sb.append(top).append(" ");
            }else{
                break;
            }
        }
        
        if(result == 0){
            System.out.println(0);
            return;
        }
        System.out.println(result);
        System.out.println(sb.toString());
    }
}