import java.util.*;
class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        StringBuilder sb = new StringBuilder();
        int dist = getDist(x,y,r,c);
        if(dist>k || (k-dist)%2!=0) return "impossible";
        
        while(k-->0){
            
            int ux = x - 1;
            int dx = x + 1;
            int uy = y + 1;
            int dy = y - 1;
            
            // d
            if(dx <= n && k>=getDist(dx, y, r, c)){
                sb.append('d');
                x = dx;
            }
            // l
            else if(dy>=1 && k>=getDist(x,dy,r,c)){
                sb.append('l');
                y = dy;
            }
            // r 
            else if(uy <= m && k>=getDist(x,uy,r,c)){
                sb.append('r');
                y = uy;
            }
            // u
            else{
                sb.append('u');
                x = ux;
            }
            
        }
        
        return sb.toString();
    }
    
    private int getDist(int x, int y, int r, int c){
        return Math.abs(x-r) + Math.abs(y-c);
    }
}