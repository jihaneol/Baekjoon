import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n,m;
	static class Minsu{
		int x,y,cnt;
		int c;
		public Minsu(int x, int y, int c,int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
	static Queue<Minsu> queue;
	public static void main(String[] args) throws IOException {
		br =new  BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		char[][] map = new char[n][m];
		queue = new LinkedList<>();
		for(int i = 0; i<n; i++) {
			char si[] = br.readLine().toCharArray();
			for(int j=0; j<m; j++) {
				map[i][j] = si[j];
				if(si[j] == '0') {
					queue.add(new Minsu(i,j,0,0));
					map[i][j]='.';
				}
			}
		}
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		boolean[][][] visited = new boolean[n][m][64];
		visited[queue.peek().x][queue.peek().y][0]=true;
		
		while(!queue.isEmpty()) {
			Minsu now = queue.poll();
			
			
			if(map[now.x][now.y]=='1'){
				System.out.println(now.cnt);
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = now.x+ dx[i];
				int ny = now.y + dy[i];
				
				if(!isRange(nx,ny)) continue;
				if(visited[nx][ny][now.c] ||map[nx][ny] == '#') continue;
				if(map[nx][ny] == '.' ||map[nx][ny]=='1') { // 빈곳
						visited[nx][ny][now.c]=true;
						queue.add(new Minsu(nx,ny,now.c,now.cnt+1));
					
				}else if(keyCheck(map[nx][ny])){ // key
					int key = (1<< (map[nx][ny]-'a'));
						key = now.c |key;
							
							visited[nx][ny][key] = true;
							queue.add(new Minsu(nx,ny,key, now.cnt+1));
				}else if(map[nx][ny] >= 'A' && map[nx][ny] <= 'F'){ // 대문
					if( (now.c & (1 << (map[nx][ny] -'A'))) != 0) { // 열쇠 있다면 지나가 세요..
						
						visited[nx][ny][now.c]=true;
						queue.add(new Minsu(nx,ny,now.c,now.cnt+1));
					}
					
				}
			}
		}
		System.out.println(-1);
		
	}
	public static boolean isRange(int x, int y) {
		
		return 0<=x && 0<=y && n>x && m>y;
		
	}
	public static boolean keyCheck(char c) {
		return 0<=c-'a' && 'f'-'a'>=c-'a';
	}

}














