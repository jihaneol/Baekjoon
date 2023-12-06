import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes,(int[] x, int[] y) ->
            Integer.compare(x[1] , y[1])          
                   );
        int[] cam = routes[0];
        for(int i = 1; i<routes.length; i++){
            if(cam[1]<routes[i][0]){
                answer++;
                cam = routes[i];
            }
            
        }
        return answer;
    }
}