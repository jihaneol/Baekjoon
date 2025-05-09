import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] type = new int[10];
        int count = 0; // 종류 개수

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        int answer = 0;

        int s = 0;
        int e = 0;
        while (e < n) {
            // e 움직이기
            while (e < n) {
                int num = arr[e];
                if (type[num] == 0) {
                    count++;
                    if (count == 3) {
                        type[num]++;
                        break;
                    }
                }
                type[num]++;
                e++;
            }
            answer = Math.max(answer, e - s);
            // s 움직이기
            while (s < e && count > 2) {
                int num = arr[s];
                if (type[num] == 1) {
                    count--;
                }
                type[num]--;
                s++;
            }
            e++;
        }
        System.out.println(answer);

    }
}