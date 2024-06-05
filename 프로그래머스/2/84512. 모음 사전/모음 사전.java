class Solution {
    String target;
    boolean isEnd, last;
    String[] words = {"A","E","I","O","U"};
    int answer = 0;
    int cnt = 0;
    public int solution(String word) {
        target = word;
        isEnd = false;
        last = false;
        recur("",0);
        return answer;
    }
    
    public void recur(String w ,int depth){
        if(isEnd) return;
      
        if(target.equals(w)){
            isEnd = true;
            answer = cnt;
            return;
        }
        if(last){
          return;
        }
        
        if(depth==5){
            return;
        }
        
        for(int i=0; i<5; i++){
            cnt++;
            recur(w+words[i], depth+1);
            if(depth==1){
                last = false;
            }
        }
        
        
    }
}