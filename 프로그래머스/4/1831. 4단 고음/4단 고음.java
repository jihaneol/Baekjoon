class Solution {
    private int answer;
    public int solution(int n) {
        
        backTracking(n,0);
        
        return answer;
    }
    public void backTracking(int now, int charge){
         
        if(now < Math.pow(3, charge/2)){
            
            return;
        }
        // +, ++(*), +++(*), ++++(**) -> cnt==0 이고 now==1 일때 성공
        if(now==1 && charge==0){
            answer++;
            return;
        }
        if(charge>=2 && now%3==0){
            backTracking(now/3, charge-2);
        }
        backTracking(now-1, charge+1);
    }
}