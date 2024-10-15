class Solution {
    
    private int[][] dir = {{0,0},{0,1},{0,-1},{1,0},{-1,0}};
    private int n, answer;
    public int solution(int[][] clockHands) {
        n = clockHands.length;
        answer = Integer.MAX_VALUE;
        // 첫줄을 해결 4**n으로 하여서 돌릴 개수를 설정 해준다.
        // 총 시간 복잡도 4**n * n**2
        for(int i=0; i<Math.pow(4,n); i++){ // 00 ~ 11
            int[][] copy = deepCopy(clockHands);
            int bit = i;
            int total = 0;
            for(int j=0; j<n; j++){
                //횟수
                int cnt = bit%4;
                total+=cnt;
                //첫출 배열 돌리기.
                rotateClock(0,j,copy,cnt);
                bit>>=2;
            }
            dfs(n, total, copy);
        }
        return answer;
    }
    private void print(int[][] map){
        for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
                System.out.println();
            
    }
    private int[][] deepCopy(int[][] origin){
        int[][] copy = new int[n][n];
        for(int i=0; i<n; i++){
            copy[i] = origin[i].clone();
        }
        return copy;
    }
    private void dfs(int xy, int total, int[][] map){
        if(xy == n*n){
            // 전체 0으로 되어있는지 확인
            for(int[] row : map){
                for(int n : row){
                    if(n!=0) return;
                }
            }
            answer = Math.min(total,answer);
      
            
            return;
        }
        
        int x = xy/n;
        int y = xy%n;
        int rotateCnt = map[x-1][y];
        // x-1 부분 0인지 아닌지 확인
        if(rotateCnt==0){
            dfs(xy+1, total, map);
            return;
        }
        // 배열 돌리기
        rotateClock(x,y, map, 4-rotateCnt);
        dfs(xy+1, total+4-rotateCnt, map);
    }
    private void rotateClock(int x, int y, int[][] copy, int cnt){
        for(int i=0; i<5; i++){
            int nx = dir[i][0]+ x;
            int ny = dir[i][1]+ y;
            if(!isRange(nx,ny)) continue;
            copy[nx][ny] = (copy[nx][ny]+cnt)%4;
        }
    }
    private boolean isRange(int x, int y){
        return x>=0 && x<n && y>=0 && y<n;
    }
}