import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static class Node{
		int vertix;
		Node link;
		public Node(int vertix, Main.Node link) {
			super();
			this.vertix = vertix;
			this.link = link;
		}
		
	}
	static Node[] graph;
	static boolean[] visited;
	static boolean check;
	public static void main(String[] args) throws Exception{
		br  = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		graph = new Node[N];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			graph[from] = new Node(to, graph[from]);
			graph[to] = new Node(from, graph[to]);
		}
        visited = new boolean[N];
		for(int i=0; i<N; i++) {
			
			if(check) {
				System.out.println(1);
				return;
			}
			dfs(i,0);
		}
		System.out.println(0);
	}
	public static void dfs(int start,int depth) {
		
		if(depth==4) {
			check=true;
			return;
		}
		visited[start]= true;
		for(Node temp=graph[start];temp!=null;temp=temp.link) {
			if(!visited[temp.vertix])
			dfs(temp.vertix,depth+1);
		}
		visited[start]=false;
	}
	
}