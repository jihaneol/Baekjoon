import java.util.*;
class Solution {
    
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new ArrayDeque();
        Queue<Integer> q2 = new ArrayDeque();
        long q1_sum = 0;
        long q2_sum = 0;
        for(int i=0; i<queue1.length; i++)
        {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            q1_sum+=queue1[i];
            q2_sum+=queue2[i];
        }
        long target = (q1_sum+q2_sum)/2;
        while(q1_sum != q2_sum){
            if(answer > (queue1.length+queue2.length)*2)
            {
                return -1;
            }
            if(q1_sum<target)
            {
                q1_sum+=q2.peek();
                q2_sum-=q2.peek();
                q1.add(q2.poll());
                answer++;
            }
            else if(q2_sum<target)
            {
                q2_sum+=q1.peek();
                q1_sum-=q1.peek();
                q2.add(q1.poll());
                answer++;
            }
            else
            {
                return answer;
            }
        }
        
        
        return answer;
    }
}