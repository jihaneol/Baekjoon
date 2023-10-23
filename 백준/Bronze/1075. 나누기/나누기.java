

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a = Integer.valueOf(br.readLine());
        int b = Integer.valueOf(br.readLine());

        a = a/100*100;

        for(int i=0; i<100; i++){
            if(a%b==0){
                break;
            }
            a++;
        }
        a = a%100;
        if(a/10 == 0){
            System.out.println("0"+a);
        }else{
            System.out.println(a);
        }
    }

}