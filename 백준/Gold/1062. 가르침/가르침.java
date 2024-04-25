import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int n, k, answer;
    static boolean selected[];
    static String[] words;
    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        if(k<5){
            System.out.println(0);
            System.exit(0);
        }

        words = new String[n];
        selected = new boolean[26];
        selected['a'-'a'] = true;
        selected['n'-'a'] = true;
        selected['t'-'a'] = true;
        selected['i'-'a'] = true;
        selected['c'-'a'] = true;


        for(int i=0; i<n; i++){
            String word = sc.next();
            String substring = word.substring(4, word.length() - 4);
            words[i] = substring;
        }
        findword(5,1);

        System.out.println(answer);
    }
    public static void findword(int cnt, int x){
        if(cnt == k){
            int wordnum = 0;

            for(String s : words){
                boolean flag = true;
                for(int i=0; i<s.length(); i++){
                    if(!selected[s.charAt(i)-'a']){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    wordnum++;
                }
            }

            answer = Math.max(answer,wordnum);
        }

        for(int i=x; i<26; i++){

            if(!selected[i]){
                selected[i] = true;

                findword(cnt+1,i);
                selected[i] = false;
            }
        }

    }
}