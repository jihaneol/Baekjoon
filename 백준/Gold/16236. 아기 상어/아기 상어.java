import java.io.*;
import java.util.*;
public class Main {
    private static class Shark {
        int x,y,size,feedCnt;
        Shark(int x, int y){
            this.x = x;
            this.y = y;
            this.size = 2;
            this.feedCnt = 0;
        }

        public void fishEat(int x, int y){
            feedCnt++;
            if(size == feedCnt) {
                size++;
                feedCnt = 0; //-> 문제 설명이 너무 불친절하다.
            }
            positionChange(x,y);

        }

        private void positionChange(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int[] nowPosition(){
            return new int[] {this.x, this.y};
        }

    }
    
    private static class Position{
        int r, c;
        Position(int r, int c){
            this.r = r;
            this.c = c;
        }

        Position(int[] arr){
            this(arr[0],arr[1]);
        }
    }
    
    private static Shark shark;
    private static int n,time;
    private static int[][] map;
    private static boolean[][] visited;

    private static int[] fish;

    private static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        time = 0;
        n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        map = new int[n][n]; //1초뒤 3초뒤 5초뒤
        visited = new boolean[n][n];
        // 초기
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    map[i][j] = 0;
                    shark = new Shark(i, j);
                }
            }
        }

        while(true){
            for(int i=0; i<n; i++){
                Arrays.fill(visited[i],false);
            }
            if(!found()){
                break;
            }
        }

        System.out.println(time);

    }
    public static void feed(){

    }


    public static boolean found(){ //초기, 다음
        Deque<Position> q = new ArrayDeque<>();
        int tempTime = 0;
        q.add(new Position(shark.nowPosition()));
        visited[shark.x][shark.y] = true;
        List<int[]> food = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            for(int t=0; t<size; t++){
                Position now = q.poll();
                for(int i=0; i<4; i++){
                    int nx = dir[i][0] + now.r;
                    int ny = dir[i][1] + now.c;
                    if(!isRange(nx,ny) || map[nx][ny] > shark.size || visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    if(shark.size > map[nx][ny] && map[nx][ny] !=0){
                        food.add(new int[] {nx,ny});
                    }else{
                        q.add(new Position(nx, ny));
                    }

                }
            }
            tempTime++;
            if(food.size() != 0){
                Collections.sort(food, (int[] a, int[] b) -> {
                    return a[0] != b[0] ? Integer.compare(a[0],b[0]) : Integer.compare(a[1],b[1]);
                });
                int[] f =  food.get(0);

                shark.fishEat(f[0],f[1]);
                time+=tempTime;
                map[f[0]][f[1]] = 0;
                return true;
            }
        }

        return false;

    }

    public static boolean isRange(int x, int y){
        return x>=0 && y>=0 && x<n && y<n;
    }

}
