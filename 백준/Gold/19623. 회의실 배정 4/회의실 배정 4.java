import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] board ;
	public static void main(String[] args) throws IOException {
		br =new  BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken());
		board = new int[N][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			board[i][0] = Integer.valueOf(st.nextToken());
			board[i][1] = Integer.valueOf(st.nextToken());
			board[i][2] = Integer.valueOf(st.nextToken());
		}
		Arrays.sort(board,(o1,o2)->{
		    return	o1[1]-o2[1];
		});
		int[] dp = new int[N];
		dp[0] = board[0][2];
		
		for(int i=1; i<N; i++) {
			int mid = binarySearch(0,i,board[i][0]);
			if(mid==-1) {
				dp[i] = Math.max(board[i][2],dp[i-1]); 
			}else {
				dp[i] = Math.max(dp[i-1],board[i][2]+dp[mid]);
			}
			
		}
		System.out.println(dp[N-1]);
		
	}
	public static int binarySearch(int s, int e, int target) {
		while(s<e) {
			int mid = (s+e)/2;
			if(target<board[mid][1]) {
				e=mid;
			}else {
				s=mid+1;
			}
		}
		return s-1;
		
	}

}
