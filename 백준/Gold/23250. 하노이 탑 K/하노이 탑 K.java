import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N;
    static long cnt, K;
    static long[] moveNum;

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        moveNum = new long[N + 1];
        long num = 1;
        for (int i = 1; i <= N; i++) {
            moveNum[i] = num * 2 - 1;
            num *= 2;
        }


        hanoi(N, 1, 3, 2);
    }

    public static void hanoi(int n, int from, int to, int temp) {
        if(n==0) return;
        if (K-moveNum[n-1]<=0){
            hanoi(n - 1, from, temp, to);
        }else {
            K-=moveNum[n-1];
        }
        K-=1;
        if(K==0){
            System.out.println(from + " " + to);
            System.exit(0);
        }

        if (K-moveNum[n-1] <= 0) {
            hanoi(n - 1, temp, to, from);
        }else {
            K-=moveNum[n-1];
        }
    }

}