
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().split("");
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean isopen = false;
        for (String word : words) {
            if (word.equals("<")) {
                flush(sb,stack);
                isopen = true;
                sb.append(word);
                continue;
            } else if (word.equals(">")) {
                sb.append(">");
                isopen = false;
                continue;
            }
            // 닫혀있다면
            if (!isopen) {
                if (word.equals(" ")) {
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
    public static void flush(StringBuilder sb,Stack<String> stack){
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }


}