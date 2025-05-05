import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        String c = sc.next();

        int answer;

        if(isInteger(a)){
            answer = Integer.parseInt(a)+3;
        } else if(isInteger(b)){
            answer = Integer.parseInt(b)+2;
        } else {
            answer = Integer.parseInt(c)+1;
        }

        System.out.println(fizzbuzz(answer));

    }

    private static boolean isInteger(String a) {
        for(int i = 0; i < a.length(); i++){
            char c = a.charAt(i);
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }

    private static String fizzbuzz(int n) {
        if(n % 3 == 0 && n % 5 == 0){
            return "FizzBuzz";
        }
        if(n%3==0 && n % 5 != 0){
            return "Fizz";
        }
        if(n%5==0 && n % 3 != 0){
            return "Buzz";
        }
        return String.valueOf(n);
    }


}