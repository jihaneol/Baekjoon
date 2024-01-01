import java.util.*;
import java.lang.*;
class Solution {
    StringBuilder route;
    char[] dir = {'d', 'l', 'r', 'u'};
    int[] rdir = {1, 0, 0, -1};
    int[] cdir = {0, -1, 1, 0};
    int endRow, endCol;
    int arrRow, arrCol; //미로 길이
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        route = new StringBuilder();
        endRow = r; endCol = c;
        arrRow = n; arrCol = m;
        //최단거리 계산 - 거리 k로 갈 수 있는지 여부
        int length = distance(x, y, r, c);
        if((k - length) % 2 == 1 || k < length) return "impossible";
  
        return !dfs(x,y,0,k) ? "impossible" : route.toString();
    }

    private int distance(int x, int y, int r, int c){
        return Math.abs(x-r) + Math.abs(y-c);
    }

    private boolean dfs(int r, int c, int depth, int k){
        
        if(depth + distance(r, c, endRow, endCol) > k) return false; //현재 깊이 + 남은 거리 > k
        if(k == depth) {
            return true;
        }
        for(int i=0; i<4; i++){
            int nextRow = r + rdir[i];
            int nextCol = c + cdir[i];
            if(nextRow <= arrRow && nextCol <= arrCol && nextRow > 0 && nextCol >0){
                route.append(dir[i]);
                if(dfs(nextRow, nextCol, depth+1, k)){
                    return true;
                }
                route.delete(depth, depth+1);
            }
        }
        return false;
    }
}