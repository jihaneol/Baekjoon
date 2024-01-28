import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static  BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());
		
		int[] coins = new int[n];
		int[] dp = new int[k+1];
		for(int i=0; i<n; i++) {
			coins[i] = Integer.valueOf(br.readLine());
		}
        Arrays.sort(coins);
		Arrays.fill(dp, 100001);
		dp[0]=0;
		for(int i=1; i<k+1; i++) {
			for(int j=0; j<coins.length; j++) {
				if(i-coins[j]>=0) {
					dp[i] = Math.min(dp[i-coins[j]]+1,dp[i]);					
				}else {
					break;
				}
				
			}
		}
		if(dp[k]==100001) {
			System.out.println(-1);
		}else {
			System.out.println(dp[k]);
		}
	}
}