

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		// 정답 배열
		Node[] arr = new Node[n];
		
		StringTokenizer st = null;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			Node now =  new Node(Integer.valueOf(st.nextToken()),i);
			arr[i] = now;
		}
		
		Arrays.sort(arr);
		int max = 0,now=0;
		for(int i=0; i<n; i++) {
			now = arr[i].idx-i;
			if(max<now) max=now;
		}
		System.out.println(max+1);
		
		
	}
	public static class Node implements Comparable<Node>{
		int value,idx;

		public Node(int value, int idx) {
			super();
			this.value = value;
			this.idx = idx;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.value-o.value;
		}
		

	}

}
