


import java.util.Scanner;

public class Main {
    static int cnt;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            cnt = 0;
            int N = sc.nextInt();

            // 1,2,3 으로 조합 만들기
            dfs(N,0);
            System.out.println(cnt);

        }

    }

    // N은 만들수 sum 합친수
    static void dfs(int N, int sum) {
        if (sum == N) {
            cnt++;
            return;
        } else if (N > sum) {

            for (int i = 1; i < 4; i++) {
                sum += i;
                dfs(N, sum);
                sum -= i;
            }

        }
    }

}
