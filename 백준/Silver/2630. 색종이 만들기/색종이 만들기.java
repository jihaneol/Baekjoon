import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;


public class Main {
	static int zero,one,arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		arr = new int[n][];
		for(int i=0; i<n; i++) {
			arr[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
		}
		divide(n,n-1,n-1);
		System.out.println(zero);
		System.out.println(one);
	}
	public static void divide(int n,int x, int y) {
		if(!check(n,x,y)) {
			divide(n/2,x-n/2,y-n/2);
			divide(n/2,x,y-n/2);
			divide(n/2,x-n/2,y);
			divide(n/2,x,y);
		}
		
	}
	public static boolean check(int n, int i, int j) {
		int chk = arr[i][j];
		for(int a=i-n+1;a<=i;a++) {
			for(int b=j-n+1; b<=j; b++) {
				if(arr[a][b]!=chk) {
					return false;
				}
			}
		}
		if(chk==0) {
			zero++;
		}else {
			one++;
		}
		return true;
	}

}
