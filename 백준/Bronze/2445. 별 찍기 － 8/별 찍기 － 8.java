import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int row = n*2;
        for(int r=1; r<=row; r++){
            if(r<=n){
                for(int c=r; c>0; c--) System.out.print("*");
                for( int t=row-2*r; t>0; t--) System.out.print(" ");
                for(int c=r; c>0; c--) System.out.print("*");

            }else{
                int temp = row-r;
                for(int c=temp; c>0; c--) System.out.print("*");
                for( int t=row-temp*2; t>0; t--) System.out.print(" ");
                for(int c=temp; c>0; c--) System.out.print("*");
            }
            System.out.println();
        }

    }
}