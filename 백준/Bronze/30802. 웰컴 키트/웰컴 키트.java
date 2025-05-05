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

        int tBundle = 0;
        for (int i = 0; i < 6; i++) {
            int s = shirts[i];
            tBundle += (s + t - 1) / t;
        }
        System.out.println(tBundle);
        System.out.print(n / p + " ");
        System.out.print(n % p);
    }
}