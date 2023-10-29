

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test = Integer.valueOf(br.readLine());
        int ans = 0;
        while (test-- > 0) {
            boolean chk[] = new boolean['z' - 'a'+1];
            boolean flag = true;
            Stack<Integer> stack = new Stack();

            char[] charArray = br.readLine().toCharArray();

            stack.add(charArray[0] - 'a');
            chk[charArray[0] - 'a'] = true;
            for (int i = 1; i < charArray.length; i++) {
                int now = charArray[i] - 'a';

                if (stack.peek() != now) {
                    if (chk[now]) {
                        flag = false;
                        break;
                    } else {
                        stack.pop();
                        stack.add(now);
                        chk[now] = true;
                    }
                }
            }

            if(flag){
                ans++;
            }

        }
        System.out.println(ans);

    }

}






