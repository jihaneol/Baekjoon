class Solution {
    public int solution(int n, int w, int num) {
        int answer = 1;
        int h = 0; //현재 층
        while(h*w<num) h++;
        int diff = 0; // 차이
        if(h%2==0){
            diff = num-(w*(h-1)+1);          
        }else{
            diff = w*h-num;
        }
  
        while(true){
            h++;
            int now = 0;
            if(h%2==0){
                now = diff+w*(h-1)+1;
            }else{
                now = w*h-diff;
            }
            if(now>n) break;
            answer++;
        }
        
        
        return answer;
    }
}