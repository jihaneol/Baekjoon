import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main { 
	static BufferedReader br;
	static StringTokenizer st;
	static int N,answer;
	static List<Integer>[] graph;
	static boolean[] area;
	static int[] peopleNum;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		peopleNum = new int[N+1];
		st = new StringTokenizer(br.readLine());
		answer = Integer.MAX_VALUE;
		for(int i=1; i<N+1; i++) {
			peopleNum[i] = Integer.valueOf(st.nextToken());
		}
		
		graph = new List[N+1];
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.valueOf(st.nextToken());
			graph[i] = new ArrayList<>();
			for(int j=0; j<m; j++) {
				graph[i].add(Integer.valueOf(st.nextToken()));
			}
		}
		for(int i=1; i<N; i++) {
			divide(1, 0,i, new boolean[N+1]);
		}
		
		if(answer==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(answer);
		}

	}
	public static void divide(int idx,int depth,int r,boolean[] visited) { // 뽑자
		if(r==depth) {
//			System.out.println(Arrays.toString(visited));
			List<Integer> A = new ArrayList<>();
			List<Integer> B = new ArrayList<>();
			for(int i=1; i<N+1; i++) {
				if(visited[i]) {
					A.add(i);
				}else {
					B.add(i);
				}
			}
			area = new boolean[N+1];
			if(isConnected(A) && isConnected(B)) {
				int num= sum(visited);
				if(answer>num) {
					answer=num;
				}
			}
			return;
		}
		for(int i=idx; i<=N; i++) {
			visited[i]=true;
			divide(i+1, depth+1, r, visited);
			visited[i]=false;
		
		}
	}
	public static boolean isConnected(List<Integer> dang) {
		
		Queue<Integer> q = new LinkedList<>();
		int c=1;
		q.add(dang.get(0));
		area[dang.get(0)]=true; // 지역에 포함 시키기
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int next : graph[now]) {
				if(!area[next] && dang.contains(next)) { // 그래프상에 연결되있고 지역에 포함 안되있으며 당에 있다면
					q.add(next);
					area[next]=true;
					c++;
				}
			}
		}
		if(c==dang.size()) {
			return true;
		}
		return false;
		
		
	}
	public static int sum(boolean[] vi) {
		int a=0,b=0;
		for(int i=1; i<N+1; i++) {
			if(vi[i]) {
				a+=peopleNum[i];
			}else {
				b+=peopleNum[i];
			}
		}
		return Math.abs(a-b);
	}

}
