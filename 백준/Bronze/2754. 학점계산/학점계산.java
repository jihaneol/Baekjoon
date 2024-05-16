import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        char[] charArray = sc.next().toCharArray();

        char alpha = charArray[0];
        if(alpha == 'F'){
            System.out.println(0.0);
            System.exit(0);
        }
        char grade = charArray[1];
        float ans = 0;
        ans += alphaScore(alpha);
        ans += gradeScore(grade);

        System.out.println(ans);

    }

    private static float gradeScore(char grade) {
        switch (grade){
            case '+':
                return 0.3f;
            case '-':
                return -0.3f;
        }
        return 0;
    }

    private static int alphaScore(char alpha) {
        switch (alpha) {
            case 'A':
                return 4;
            case 'B':
                return 3;
            case 'C':
                return 2;
            case 'D':
                return 1;
        }
        return 0;
    }
}