class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int front = 0;
        
        for(char word : s.toCharArray()){
            if(word=='('){
               front++; 
            }else if(front>0 && word==')'){
                front--;
            }else{
                return false;
            }
        }

        return front==0;
    }
}