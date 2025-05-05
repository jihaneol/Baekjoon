import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] shirts = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int t = sc.nextInt();
        int p = sc.nextInt();

        int total = 0;
        for(int i=0; i<6; i++){
            int s = shirts[i];
            if(s%t==0){
                total += s/t;
            }else{
                total += s/t+1;
            }
        }
        System.out.println(total);
        int cnt = n/p;
        System.out.print(cnt + " ");
        System.out.print(n - cnt*p);
   }
}