import java.util.*;
class Main {
    private static int n, m,ans,cnt;
    private static int[] data;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        data = new int[n];

        for(int i=0; i<n; i++){
            data[i] = sc.nextInt();
        }

        subsequence(0,0);

        System.out.println(ans);
    }

    private static void subsequence(int idx, int sum) {
        
        if(idx==n) return;
        int now = data[idx];

        if(now+sum==m) {
            ans++;
        }

        subsequence(idx+1, sum);
        subsequence(idx+1, sum+now);

    }
}