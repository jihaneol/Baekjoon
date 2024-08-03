import java.util.*;
public class Main {
    private static int N, K;
    private static int[] dp;

    public static void main(String[] args) {
        init();
        bfs(N);
        System.out.println(dp[K]);
    }

    public static void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        dp = new int[100001];
        Arrays.fill(dp,-1);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        dp[start] = -1;
        q.add(start);
        int depth = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            depth++;
            for (int i = 0; i < len; i++) {
                int now = q.poll();

                if (now == K) {
                    System.out.println(depth-1);
                    Stack<Integer> stack = new Stack<>();
                    while (dp[now] != -1) {
                        stack.push(now);
                        now = dp[now];
                    }
                    stack.push(now);
                    while (!stack.isEmpty()) {
                        System.out.print(stack.pop()+" ");
                    }
                    System.exit(0);
                }
                int next;
                for(int j=0; j<3; j++){
                    if(j==0) next = now-1;
                    else if(j==1) next = now+1;
                    else next = now*2;

                    if(next >=0 && next<100001 && dp[next]==-1 && next!=N){
                        q.add(next);
                        dp[next] = now;
                    }
                }
            }

        }
    }

}
