import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    static int N, M;
    static int[] arr;

    static Stack<Integer> stack;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        backtraking(0,0);
        System.out.println(sb.toString());
    }

    public static void backtraking(int depth,int x) {
        if(M==depth){
            Iterator<Integer> iterator = stack.iterator();
            while (iterator.hasNext()){
                sb.append(iterator.next()).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=x; i<N; i++){
            stack.push(arr[i]);
            backtraking(depth+1,i);
            stack.pop();
        }
    }


}