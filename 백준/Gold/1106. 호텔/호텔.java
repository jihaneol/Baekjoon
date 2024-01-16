import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.valueOf(st.nextToken());
		int N = Integer.valueOf(st.nextToken());
		int dp[] = new int[C+100]; //비용
		Arrays.fill(dp,1002*100);
		List<int[]> cities = new ArrayList<>(); // 0 비용, 1 고객
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			int cost = Integer.valueOf(st.nextToken());
			int person = Integer.valueOf(st.nextToken());
			// 이 부분 추가
			if(dp[person]!=1002*100) dp[person] = Math.min(dp[person],cost);
			else dp[person] = cost;
			cities.add(new int[] {cost,person});
		}
		// 고객
		for(int i=1; i<=C; i++){
			for(int[] city : cities){
				if(dp[i] ==1002*100) continue;
				dp[city[1]+i] = Math.min(dp[city[1]+i],city[0]+dp[i]);
			}
		}
		int min = 1002*100;
		for(int i=C; i<C+100; i++){
			min = Math.min(min,dp[i]);
		}
		System.out.println(min);

	}
}
/**
 import java.io.*;
 import java.util.*;
 public class Main {

 	public static void main(String[] args) throws Exception {

		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 int C = Integer.valueOf(st.nextToken());
		 int N = Integer.valueOf(st.nextToken());
		 int dp[] = new int[1001]; //비용
		 Arrays.fill(dp,1002*100);
		 List<int[]> cities = new ArrayList<>(); // 0 비용, 1 고객
		 for(int i=0; i<N; i++){
			 st = new StringTokenizer(br.readLine());
			 int cost = Integer.valueOf(st.nextToken());
			 int person = Integer.valueOf(st.nextToken());
			 if(dp[person]!=1002*100) dp[person] = Math.min(dp[person],cost);
			 else dp[person] = cost;
			 cities.add(new int[] {cost,person});
		 }
		 // 고객
		 for(int i=1; i<=C; i++){
		 	for(int[] city : cities){
		 	if(dp[i] ==1002*100) continue;

             if(city[1]+i>C){
			 	dp[C] = Math.min(dp[C],city[0]+dp[i]);
			 }else{
			 	dp[city[1]+i] = Math.min(dp[city[1]+i],city[0]+dp[i]);
			 }
		 	}
		 }
		 System.out.println(dp[C]);
 	}
 }

 */