import java.util.Scanner;


public class Main {
    private static  int n,m;
    private static  int[][] dp, map;
    private static  int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        dp = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0,0));
    }

    private static int dfs(int x, int y) {

        if(x==n-1 && y==m-1) return 1;

        if(dp[x][y]!=-1) return dp[x][y];
        dp[x][y] = 0;
        int nx, ny;
        for(int i=0; i<4; i++){
            nx = x + dir[i][0];
            ny = y + dir[i][1];

            if(!isRange(nx,ny) || map[x][y]<=map[nx][ny]) continue;

            dp[x][y] += dfs(nx, ny);
        }

        return dp[x][y];
    }

    private static boolean isRange(int nx, int ny) {
        return nx>=0 && ny>=0 && nx<n && ny<m;
    }

}
