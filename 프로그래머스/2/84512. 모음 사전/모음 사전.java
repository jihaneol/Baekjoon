class Solution {
    String target;
    String[] words = {"A","E","I","O","U"};
    int answer = 0;
    int cnt = 0;
    public int solution(String word) {
        target = word;
   
        recur("",0);
        return answer;
    }
    
    public void recur(String w ,int depth){
      
        if(target.equals(w)){
        
            answer = cnt;
            return;
        }
        
        if(depth==5){
            return;
        }
        
        for(int i=0; i<5; i++){
            cnt++;
            recur(w+words[i], depth+1);
            if(answer!=0) return;
         
        }
        
    }
}