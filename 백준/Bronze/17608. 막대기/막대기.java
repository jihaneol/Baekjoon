import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.valueOf(br.readLine());
        int cnt = 0;
        int now = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++){
            stack.add(Integer.valueOf(br.readLine()));
        }

        while(!stack.isEmpty()){
            if(stack.peek()>now){
                now = stack.pop();
                cnt++;
            }else{
              stack.pop();
            }
        }
        System.out.println(cnt);
    }

}