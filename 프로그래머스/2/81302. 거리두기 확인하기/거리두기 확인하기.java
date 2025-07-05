import java.util.*;
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        // 잘 지키면 1, 안 지키면 0
        Arrays.fill(answer, 1);
        int[][] dir = {{0,1}, {1,0}, {-1,0},{0,-1}};
        int[][] dia = {{1,-1},{1,1},{-1,-1},{-1,1}};
        
        for(int t=0; t<5; t++){
            String[] place = places[t];
  loop : for(int r=0; r<5; r++){
            for(int c=0; c<5; c++){
                if('P' == place[r].charAt(c)){
                    // 4 방향
                    for(int i=0; i<4; i++){
                        int nx = r;
                        int ny = c;
                        for(int j=0; j<2; j++){
                            nx += dir[i][0];
                            ny += dir[i][1];
                            if(nx<0 || ny<0 || nx>=5 || ny>=5) break;
                            if('X' == place[nx].charAt(ny)){
                                break;
                            }
                            if('P' == place[nx].charAt(ny)){
                                answer[t] = 0;
                                break loop;
                            }
                        }
                    }
                
                    // 대각선
                    for(int i=0; i<4; i++){
                        int nx = r + dia[i][0];
                        int ny = c + dia[i][1];
                        
                        if(nx<0 || ny<0 || nx>=5 || ny>=5) continue;
                        
                        if(place[nx].charAt(ny)=='P'){
                            if(
                                place[nx-dia[i][0]].charAt(ny) != 'X' 
                                || 
                               place[nx].charAt(ny-dia[i][1]) != 'X'){
                                
                                answer[t]=0;
                                break loop;
                            }
                        }
                    }
                }
            }
        }
            
        }
        
        return answer;
    }
}