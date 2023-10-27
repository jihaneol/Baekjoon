
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        int[][] board = new int[N][M];
        boolean[][] isOuter = new boolean[N][M];
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                board[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0,0});
        isOuter[0][0] = true;

        int ans = -1;
        while(!q.isEmpty()){
            int size = q.size();
            //1 녹는 치즈 녹이 면서
            for(int i=0; i<size; i++){
                int[] now = q.poll();
                board[now[0]][now[1]] =2;
                for(int c=0; c<4; c++){
                    int nx = dx[c] + now[0];
                    int ny = dy[c] + now[1];
                    try{
                        if( !isOuter[nx][ny] && board[nx][ny] == 0){
                            q.add(new int[] {nx,ny});
                            isOuter[nx][ny] = true;
                        }
                    }catch (Exception e){
                        continue;
                    }
                }
            }
            // 주변 2로 바꾸기
            while(!q.isEmpty()){
                int[] now = q.poll();
                board[now[0]][now[1]] =2;
                for(int c=0; c<4; c++){
                    int nx = dx[c] + now[0];
                    int ny = dy[c] + now[1];
                    try{
                        if( !isOuter[nx][ny] && board[nx][ny] == 0){
                            q.add(new int[] {nx,ny});
                            isOuter[nx][ny] = true;
                        }
                    }catch (Exception e){
                        continue;
                    }
                }
            }

            //2 녹는 치즈 선택
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(board[i][j]==1){
                        int cnt = 0;
                        for(int c=0; c<4; c++){
                            int nx = dx[c] + i;
                            int ny = dy[c] + j;
                            try{
                                if(board[nx][ny] == 2){
                                    cnt++;
                                }
                            }catch (Exception e){
                                continue;
                            }
                        }
                        if(cnt>=2){
                            q.add(new int[] {i,j});
                        }
                    }
                }
            }
            ans++;
        }
        System.out.println(ans);
    }
}
