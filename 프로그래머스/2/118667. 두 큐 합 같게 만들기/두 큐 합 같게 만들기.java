import java.util.*;
import java.util.stream.*;
class Solution {
    
    public int solution(int[] queue1, int[] queue2) {
        
        
        long a = Arrays.stream(queue1).asLongStream().sum();
        long b = Arrays.stream(queue2).asLongStream().sum();
        int[] q = IntStream.concat(Arrays.stream(queue1), Arrays.stream(queue2))
                          .toArray();
        int answer = 0;
        int i = 0;
        int j = queue2.length;

        while(i<j && j<q.length){
   
            if(a<b){
                a+=q[j];
                b-=q[j];
                j++;
                answer++;
            }else if(a>b){
                b+=q[i];
                a-=q[i];
                i++;
                answer++;
            }else {
                break;
            }
        }
        
        return a==b? answer : -1;
    }
}