import java.util.Scanner;

public class Main {
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        long n=1, s=0;
        for (int i = 0; i < M; i++) {
            int N = sc.nextInt();
            int S = sc.nextInt();
            s = n*S+N*s;
            n*=N;
            s%=MOD;
            n%=MOD;
        }
        if(s%n==0){
            System.out.println(s/n);
        }else{
            System.out.println(s*matrix(n,MOD-2)%MOD);
        }


    }
    public static long matrix(long a, int n){
        if(n==1){
            return a;
        }
        long temp = matrix(a,n/2);

        if(n%2==0){
            return temp*temp%MOD;
        }else{
            return  (((temp*temp)%MOD)*a)%MOD;
        }
    }


}




