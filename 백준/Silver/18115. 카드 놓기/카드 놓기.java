import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        Deque<Integer> cards = new ArrayDeque<>();
        Deque<Integer> answer = new ArrayDeque<>();
        int[] commad = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            cards.add(i+1);
            commad[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=N-1; i>=0; i--){
            int comm = commad[i];
            int now = cards.poll();
            if(comm==1){
                answer.addFirst(now);
            } else if (comm==2) {
                int temp = answer.poll();
                answer.addFirst(now);
                answer.addFirst(temp);
            }else {
                answer.add(now);
            }
        }
        for(Iterator<Integer> iterator = answer.iterator(); iterator.hasNext();){
            Integer next = iterator.next();
            sb.append(next).append(" ");
        }
        System.out.println(sb.toString());


    }
}