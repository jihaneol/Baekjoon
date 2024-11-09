import java.util.*;

class Solution {

    public String solution(int n, int k, String[] cmd) { 
        Stack<Integer> remove = new Stack<>();
        int table_size = n;

        for(int i = 0; i < cmd.length; i++) {
            char c = cmd[i].charAt(0);
            switch(c) {
                case 'U' : k -= Integer.parseInt(cmd[i].substring(2));
                    break;
                case 'D' : k += Integer.parseInt(cmd[i].substring(2));
                    break;
                case 'C' :
                    remove.push(k);
                    table_size -= 1;
                    if(k == table_size) k -= 1;
                    break;
                default : 
                    int r = remove.pop(); 
                    if(k >= r) k += 1;
                    table_size += 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < table_size; i++) {
            sb.append('O');
        }
        while(!remove.isEmpty()) {
            sb.insert(remove.pop().intValue(), 'X');
        }
        return sb.toString();
    }
}