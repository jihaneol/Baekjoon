class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        StringBuilder sb = new StringBuilder();
        int moveCnt = 0;
        int remain = distance(x,y,r,c);
        if(k%2 != remain%2 || remain > k){
            return "impossible";
        }
 
        
        // 1~n,m 범위
        
        // 남은 거리 + 이동한 횟수 <= k 이면 이동.
        
        // 남은 거리 + 이동한 횟수 > k(이동 해야할 거리) 이동을 못한다.
        
       
        while(moveCnt < k){
            // d, l, r, u 순서
            if(isRange(n,m,x+1,y) && moveCnt+distance(x+1, y, r, c) <=k){
                sb.append('d');
                x = x+1;
            }
            else if(isRange(n,m,x,y-1) && moveCnt+distance(x, y-1, r, c) <=k){
                    sb.append('l');
                y -=1;
            }else if(isRange(n,m,x,y+1) && moveCnt+distance(x, y+1, r, c) <=k){
                    sb.append('r');
                y +=1;
            }else if(isRange(n,m,x-1,y) && moveCnt+distance(x-1, y, r, c) <=k){
                    sb.append('u');
                x = x-1;
            }
            moveCnt++;
        }
        

        return sb.toString();
    }
    public int distance(int x, int y, int r, int c){
        return Math.abs(x-r) + Math.abs(y-c);
    }
    public boolean isRange(int n, int m, int x, int y){
        return x>=1 && y>=1 && x <=n && y <= m;
    }
}