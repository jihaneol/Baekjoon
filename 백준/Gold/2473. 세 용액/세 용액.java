import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);


        long A = 0, B = 0, C = 0;
        long ans = Long.MAX_VALUE;

        for(int i=0; i<n-2; i++) {
            int s = i+1;
            int e = n-1;
            long sum = 0;
            while (s < e) {

                sum = arr[s] + arr[i] + arr[e];

                if (ans > Math.abs(sum)) {
                    ans = Math.abs(sum);
                    A = arr[i];
                    B = arr[s];
                    C = arr[e];
                }

                if (sum >= 0) {
                    e --;
                } else {
                    s ++;
                }
            }
            if (ans == 0) break;

        }

        System.out.println(A + " " + B + " " + C);


    }
}