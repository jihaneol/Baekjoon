import java.io.IOException;
import java.util.Scanner;

public class Main {

    static long a,b;
    static int answer;


    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        answer = Integer.MAX_VALUE;
        a = sc.nextInt();
        b = sc.nextInt();

        bt(a,0);
        if(answer == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(answer+1);
    }
    public static void bt(long now, int cnt){
       if(now>b || answer<=cnt) return;

       if(now==b){
           answer = Math.min(answer,cnt);
           return;
       }

       bt(now*10+1, cnt+1);

       bt(now*2,cnt+1);


    }
}