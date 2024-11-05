class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w1, int[] t1) {
        long answer = -1;
        int len = s.length;
        long left = 1;
        long right = (long)(10e5*2*10e9*2);
        while(left<=right){
            long mid = (left+right)/2; // 시간
            long silver = 0, gold = 0, sum = 0;
            for(int i=0; i<len; i++){
                int w = w1[i];
                int t = t1[i];
                
                long cnt = mid/(t*2);
                if(mid%(t*2)>=t){
                    cnt++;
                }
                silver += Math.min(s[i],cnt*w);
                gold += Math.min(g[i],cnt*w);
                sum += Math.min(g[i]+s[i],cnt*w);
            }
            System.out.println(silver+" "+gold+" "+sum+" "+mid);
        
            if(silver>=b && gold>=a && sum>=a+b){
                answer = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
            
        }
        return answer;
    }
}