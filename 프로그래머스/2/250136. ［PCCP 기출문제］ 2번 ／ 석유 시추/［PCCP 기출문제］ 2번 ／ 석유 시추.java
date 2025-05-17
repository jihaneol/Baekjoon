import java.util.*;
class Solution {
    private int[][] oilboard;
    private int oilNo = 1;
    private int n,m;
    private Map<Integer, Integer> oilMap = new HashMap();
    private int[][] dir = {{1,0}, {-1,0},{0,-1},{0,1}};
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        oilboard = new int[n][m];
        Set<Integer> oilVisited = new HashSet();
        for(int j=0; j<m; j++){ 
            oilVisited.clear();
            int sum = 0;
            for(int i=0; i<n; i++){
                if(land[i][j]==1){
                    if(oilboard[i][j]==0){
                        int oil = getOil(i,j, land);
                        sum+=oil;
                        oilMap.put(oilNo,oil);
                        oilVisited.add(oilNo++); 
                    }else{
                        if(!oilVisited.contains(oilboard[i][j])){
                            sum+=oilMap.get(oilboard[i][j]);
                            oilVisited.add(oilboard[i][j]);
                        }
                    }
            }
        }

            answer = Math.max(answer,sum);
        }
          
           
        return answer;
    }
    private int getOil(int x, int y, int[][] land){
        int result = 1;
        
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{x, y});
        oilboard[x][y] = oilNo;
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            for(int i=0; i<4; i++){
                int nx = now[0] + dir[i][0];
                int ny = now[1] + dir[i][1];
                
                if(nx<0 || ny<0 || nx>=n || ny>=m || land[nx][ny]==0 || oilboard[nx][ny]==oilNo) continue;
                
                oilboard[nx][ny] = oilNo;
                result++;
                q.add(new int[]{nx, ny});
            }
        }
        return result;
    }
}