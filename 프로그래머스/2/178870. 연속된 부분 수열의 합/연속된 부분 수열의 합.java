class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        // 100만에 끝내야 한다. 슬라이딩 윈도우
        int len = 10000000;
        int s = 0;
        int sum = 0;
        
        for(int e=0; e<sequence.length; e++){
            sum+=sequence[e];
            while(sum>k){
                sum-=sequence[s++];
            }
            if(sum==k && len>(e-s+1)){
                len=e-s+1;
                answer[0] = s;
                answer[1] = e;
            }
        }
        
        
        
        return answer;
    }
}