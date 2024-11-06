class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w1, int[] t1) {
        
        long answer = 1;
        int len = w1.length;
        long end = (long)10e14*2*2;
        long start = 1;
        
        while(start<=end){
            long gold = 0, silver = 0, sum = 0;
            long mid = (start+end)/2;
            
            for(int i=0; i<len; i++){
                int w = w1[i];
                int t = t1[i];
                
                long cnt = mid/(t*2);
                
                if(mid%(t*2) >=t) cnt++;
                
                gold += Math.min(g[i], cnt*w); // 금만
                silver += Math.min(s[i], cnt*w); // 은만
                sum += Math.min(g[i] + s[i], cnt*w); // 금, 은 함께
            }
            
            if(gold>=a && silver>=b && sum>=a+b){
                answer = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        
        return answer;
    }
}