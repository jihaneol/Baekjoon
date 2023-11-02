

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int N = Integer.valueOf(data[0]);
        int L = Integer.valueOf(data[1]);
        int a1 = -1;
        for(double i=L; i<=100; i++){
            double num = (2*N-(i-1)*i)/(2*i);
            if(num<0){
                break;
            }
            if(num==(int) num){
                a1 =(int)num;
                L = (int)i;
                break;
            }

        }
        if(a1<0){
            System.out.println(-1);
        }else{
            for(int i=a1; i<a1+L; i++){
                System.out.print(i+" ");
            }
        }

    }

}