import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack();
        
        for(int move : moves){
            int col = move - 1;
            
            // 크레인 뽑기
            for(int row=0; row<board.length; row++){
                if(board[row][col]!=0){
                    int doll = board[row][col];
                    board[row][col] = 0;
                    if(!stack.isEmpty() && stack.peek()==doll){
                        stack.pop();
                        answer++;
                    }else{
                        stack.push(doll);
                    }
                    break;
                }
            }
        }
        
        return answer*2;
    }
}