import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList();
        Queue<Integer> dev = new ArrayDeque();
        /**
        처음 부터 progresses, speeds를 개산하여 앞에서 부터 배포 가능 날짜를 q에 넣는다.
        q를 빼오면서 첫번째랑 그 뒤에 날짜를 비교한다.
        
        첫번째 < 뒷번째 라면 2<7 이라면 2일은 배포 1번 7을 첫번째로 바꾼다.
        7>=뒷번째들 , 7>= 2,3,4 이라면 배포 개수는 4이다.
        7<뒷번째가 되면 지금까지 배포한 4개를 answer에 넣는다.
        
        queue가 비었다면 지금까지 배포한것을 answer에 넣는다.
        **/
        for(int i=0; i<progresses.length; i++){
            int p = progresses[i];
            int s = speeds[i];
            
            dev.add(
                (100-p)>s*((100-p)/s)? (100-p)/s + 1: (100-p)/s
            );
        }
        int init = dev.poll();
        int cnt = 1;
        while(!dev.isEmpty()){
            int value = dev.poll();
            if(init>=value){
                cnt++;
            }else{
                answer.add(cnt);
                cnt=1;
                init = value;
            }
        }
        
        answer.add(cnt);
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}