class Solution {
    private StringBuilder ret = new StringBuilder();
    private int mode;
    public String solution(String code) {
        
        for(int idx = 0; idx<code.length(); idx++){
            char word = code.charAt(idx);
             if(word=='1'){
                mode ^= 1;
                 continue;
            }
            
            if(mode==0 && idx%2==0)
                addCode(word);
            else if(mode==1 && idx%2!=0)
                addCode(word);
            
           
        }
        
        return ret.length()==0? "EMPTY":ret.toString();
    }
    private void addCode(char word){
        ret.append(word);
    }
}