import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        int aLen = a.length;
        int bLen = b.length;
        int[][] dp = new int[bLen+1][aLen+1];

        for(int i=1; i<=bLen; i++){
            for(int j=1; j<=aLen; j++){
                if(a[j-1]==b[i-1]){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }

            }
        }
        if(dp[bLen][aLen]==0){
            System.out.println(0);
        }else{
            System.out.println(dp[bLen][aLen]);

            int r = bLen;
            int c = aLen;
            StringBuilder sb = new StringBuilder();
            
            while(r>0 && c>0){

                if(dp[r][c] == dp[r][c-1]){
                    c--;
                }else if(dp[r-1][c] == dp[r][c]){
                    r--;
                }else{
                    sb.append(a[c-1]);
                    r--;
                    c--;
                }
            }
            System.out.println(sb.reverse());
        }

    }
}