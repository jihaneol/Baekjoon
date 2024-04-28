import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int n,cnt;
    static long min = Long.MAX_VALUE, max;

    static String[] sign;

    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        sign = new String[n];

        for(int i=0; i<n; i++){
            sign[i] = sc.next();
        }

        bt(0,0, 0);
        System.out.println(max);
        double pow = Math.pow(10, n);
        if(min/(int)pow == 0){
            String temp = String.valueOf(min);
            temp = "0"+temp;
            System.out.println(temp);
        }else System.out.println(min);
        
    }
    public static void bt(int depth, long num, int visited){
        if(depth == n+1){
            min = Math.min(min, num);
            max = Math.max(max, num);
            return;
        }


        if(depth==0){
            for(int i=0; i<10; i++){
                bt(depth+1, num*10+i, visited | 1<< i);
            }
        }else{
            long pre = num%10;

            for(int i=0; i<10; i++){
                if((visited & 1<<i) == 1<<i) continue;

                if(sign[depth-1].equals(">")){
                    if(pre>i) bt(depth+1, num*10+i,visited | 1<< i);
                }else{
                    if(pre<i) bt(depth+1, num*10+i,visited | 1<< i);
                }
            }

        }
    }
}