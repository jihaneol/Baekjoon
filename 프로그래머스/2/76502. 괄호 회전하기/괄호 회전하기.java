import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] arr = {'[','{','('};
        
        for(int i=0; i<s.length(); i++){
            Stack<Character> stack = new Stack();
            boolean flag = true; // 올바른 괄호인지
            
            for(char word : s.toCharArray()){
                
                if('{'==word || '('==word || '['==word){
                    stack.push(word); 
                }else{
                    int idx = 0;
                    if(word=='}') idx=1;
                    if(word==')') idx=2;
                    if(stack.isEmpty() || stack.pop()!=arr[idx]) {
                        flag = false;
                        break;
                    }
                }
            }
            if(stack.isEmpty() && flag) answer++;
            char temp = s.charAt(0);
            s = s.substring(1, s.length()) + temp;
            
        }
        
        return answer;
    }
}