import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Node> stack = new Stack<Node>();
		int n = Integer.valueOf(br.readLine());
		Node temp = null;
		// 정답 배열
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			Node now =  new Node(Integer.valueOf(st.nextToken()),i);
			if(stack.isEmpty()) {
				stack.add(now);
			}else {
				// top < 현재 값 이면 pop
				while(!stack.isEmpty() &&stack.peek().value<now.value) {
					temp = stack.pop();
					arr[temp.idx] = now.value;
				}
				stack.add(now);
			}
		}
		while(!stack.isEmpty()) {
			temp = stack.pop();
			arr[temp.idx] = -1;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i:arr) {
			bw.write(i+" ");
		}
		bw.flush();
		
	}
	public static class Node{
		int value,idx;

		public Node(int value, int idx) {
			super();
			this.value = value;
			this.idx = idx;
		}
		
	}

}
