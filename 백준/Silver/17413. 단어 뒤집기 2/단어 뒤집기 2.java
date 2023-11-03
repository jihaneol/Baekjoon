
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] words = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean isopen = false;
        for (char word : words) {
            if (word == '<') {
                flush(sb,stack);
                isopen = true;
            } else if (word == '>') {
                sb.append(">");
                isopen = false;
                continue;
            }
            // 닫혀있다면
            if (!isopen) {
                if (word == ' ') {
                    flush(sb,stack);
                    sb.append(" ");
                } else {
                    stack.add(word);
                }
            } else {
                sb.append(word);
            }
        }
        flush(sb,stack);

        System.out.println(sb.toString());
    }
    public static void flush(StringBuilder sb,Stack<Character> stack){
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }


}