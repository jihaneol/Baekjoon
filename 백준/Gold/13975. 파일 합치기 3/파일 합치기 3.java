import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-->0){
            int n = sc.nextInt();
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for(int i=0; i<n; i++){
                pq.add(sc.nextLong());
            }
            long answer = 0;
            while(pq.size()>1){
                long a = pq.poll();
                long b = pq.poll();
                answer += a+b;

                pq.add(a+b);

            }

            System.out.println(answer);
        }

    }
}