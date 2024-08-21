class Solution {
    public int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int n, answer, count;
    public int solution(int[][] clockHands) {
        n = clockHands.length;
        answer = Integer.MAX_VALUE;
        int[][] copyMap = new int[n][n];
        // 첫번째 칸 해결
        for(int bit1=0; bit1<Math.pow(4,n); bit1++){
            deepCopy(copyMap,clockHands);
            
            int bit = bit1;
            int cnt = 0;
            for(int i=0; i<n; i++){
                cnt += bit%4;
                rotationClock(0,i,copyMap,bit%4);
                bit>>=2;
            }
           
            dfs(n,copyMap, cnt);
        }
       
        return answer;
    }
    public void deepCopy(int[][] temp, int[][] clock){
        for(int i=0; i<temp.length; i++){
        
            temp[i] = clock[i].clone();
        }
    }
    public void dfs(int xy, int[][] clockHands, int cnt){
        count++;
        if(xy==n*n){
            for(int[] row : clockHands){
                for(int n : row){
                    if(n!=0) return;
                }
            }
            answer = Math.min(answer, cnt);
            return;
        }
        int x = xy/n;
        int y = xy%n;
    
        if(clockHands[x-1][y]==0){
            dfs(xy+1, clockHands, cnt);
            return;
        }
        int num = 4-clockHands[x-1][y];
        //돌리기
        rotationClock(x, y, clockHands,num);
       
        dfs(xy+1, clockHands, cnt+num);
 
    }

    public void rotationClock(int x, int y,int[][] clockHands, int num){
        clockHands[x][y] = (clockHands[x][y]+num)%4; 
        for(int i=0; i<4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(!isRange(nx,ny)) continue;
            clockHands[nx][ny] = (clockHands[nx][ny]+num)%4; 
        }
    }
    public boolean isRange(int x, int y){
        return x>=0 && y>=0 && x<n && y<n;
    }
}