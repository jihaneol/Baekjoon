import java.util.Iterator;
import java.util.Scanner;

public class Main {
	
	static int N,answer;
	static boolean coL[],diagonalR[],diagonalL[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		coL = new boolean[N+1];
		diagonalL=new boolean[N*2+1];
		diagonalR=new boolean[N*2+1];
	
		setQueen(1);
		System.out.println(answer);
	}
	private static void setQueen(int rowNo) { // rowNo:놓으려고 하는 퀸의 행번호
		
		if(rowNo>N) {
			answer++;
			return;
		}
		
		for(int c=1; c<=N; c++) { //열 
			if(!isAvailable(rowNo, c)) continue;
			diagonalL[rowNo-c+N] = diagonalR[rowNo+c] = coL[c] = true;
			setQueen(rowNo+1);
			diagonalL[rowNo-c+N] = diagonalR[rowNo+c] = coL[c] = false;
		}
	}
	private static boolean isAvailable(int rowNo,int c) {
		return !diagonalL[rowNo-c+N] && !diagonalR[rowNo+c] && !coL[c];
	}		

}
