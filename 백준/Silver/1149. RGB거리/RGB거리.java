import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] RGB,temp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		RGB = new int[N][3];
		temp = new int[N][3];
		
		for(int i=0; i<N; i++) {
			st =  new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				RGB[i][j]=Integer.valueOf(st.nextToken());
				if(i==0)
				temp[i][j] =RGB[i][j];
			}
		}
		Solution(1, 0);
		int min=Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			if(temp[N-1][i]<min) {
				min=temp[N-1][i];
			}
		}
		System.out.println(min);
		
	}
	static void Solution(int depth, int check) {
//		if(depth==0) {
//			for(int i=0; i<3; i++) {
//				Solution(depth+1, i);
//			}
//		} else if(depth==N-1) {
//			for(int i=0; i<3; i++) {
//				if(check==i) continue;
//				temp[depth][i]=Math.min(temp[depth-1][(i+1)%3], temp[depth-1][(i+2)%3])+RGB[depth][i];
//			}
//		}else {
//			
//			temp[depth][1] = Math.min(temp[depth-1][0], temp[depth-1][1]) + RGB[depth][1];
//			temp[depth][0] = Math.min(temp[depth-1][1], temp[depth-1][2]) + RGB[depth][0];
//			temp[depth][2] = Math.min(temp[depth-1][0], temp[depth-1][1]) + RGB[depth][2];
//			
//			Solution(depth+1, check);
//		}
		if(depth==N) {
			return;
		}
		
			temp[depth][1] = Math.min(temp[depth-1][0], temp[depth-1][2]) + RGB[depth][1];
			temp[depth][0] = Math.min(temp[depth-1][1], temp[depth-1][2]) + RGB[depth][0];
			temp[depth][2] = Math.min(temp[depth-1][0], temp[depth-1][1]) + RGB[depth][2];
			
			Solution(depth+1, check);
		

		
	}

}
