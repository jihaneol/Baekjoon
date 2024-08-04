import java.util.*;
class Solution {
    private int[] kList;
    private int[][] reqsOrigin;
    private int answer = Integer.MAX_VALUE;
    private int k;
    public int solution(int k1, int n, int[][] reqs) {
        k=k1;
        kList = new int[k+1];
        reqsOrigin = reqs;
     
        permu(n,k,0);
        return answer;
    }
    public void start(){
        int[] copy =  kList.clone();
        List<PriorityQueue<Integer>> list = new ArrayList();
        for(int i=0; i<=k; i++){
            list.add(new PriorityQueue<Integer>((a,b) ->{
            return Integer.compare(a,b);}));
        }
        int waitTime = 0;
        for(int[] req : reqsOrigin){
            
            if(waitTime>answer) return;
            int a = req[0];
            int b = req[1];
            int k = req[2];
            
            PriorityQueue<Integer> pq = list.get(k);

            if(copy[k]>0){
                copy[k]--;
                pq.add(a+b);
            }else{
                int time = pq.poll();
                if(time>a){
                    waitTime += time - a;
                    pq.add(time+b);
                }else{
                    pq.add(a+b);
                }
               
            }
        }
        answer = waitTime;
    }
    
    public void permu(int n, int k,int depth){
        if(k-1==depth){
            kList[k] = n;
            start();
            return;
        }
        
        for(int i=1; i<n; i++){
            kList[depth+1] = i;
            permu(n-i,k,depth+1);
        }
    }

}