import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static int answer,N,M;
	static String N_str;
	static Set<Integer> broken;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 찾는 번호
		N_str =N+""; // 문자 만들기
		M = sc.nextInt(); //고장난 수
		broken = new HashSet<Integer>(); //고장 번호
		for(int i=0; i<M; i++) {
			broken.add(sc.nextInt());
		}
		
		answer= Math.abs(N-100); // 현재 위치에서 찾는 거 뺴기
		dfs(100, 0, 0);
		
		System.out.println(answer);
		
	}
	public static void dfs(int now,int depth, int cnt) {
		if(depth>N_str.length()+1) return;
		if(now==N) { //같으면 나가
			if(answer>cnt) answer=cnt;
			return;
		} 
		if(N_str.length()+1==depth||N_str.length()-1==depth || N_str.length()==depth) { //자리수 꽉채우면 나가
			if(answer> Math.abs(now-N)+depth) {
				answer=Math.abs(now-N)+depth;
			}
		
		}
		
		if(N_str.length()==1) {
			for(int i=0;i<10;i++) {
				if(!broken.contains(i)) {
					dfs(now*10+i, depth+1, cnt+1);
				}
			}
		}
		if(depth==0) {
			for(int i=0;i<10;i++) {
				if(!broken.contains(i)) {
					dfs(i, depth+1, cnt+1);
				}
			}
		} else {
			for(int i=0;i<10;i++) {
				if(!broken.contains(i)) {
					dfs(now*10+i, depth+1, cnt+1);
				}
			}
		
		
		}

	}
}