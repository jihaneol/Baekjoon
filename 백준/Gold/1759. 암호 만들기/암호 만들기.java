import java.util.*;

public class Main {
    static String[] codes;
    static int L,C;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();
        codes = new String[C];
        for(int i=0; i<C;i++){
            codes[i] = sc.next();
        }
        Arrays.sort(codes);
        permutation(0,0, 0);


    }
    public  static void permutation(int depth, int visited, int x){
        if(L==depth){

            String newWord = sb.toString();
            int a = 0; // 모음 개수
            char[] check = {'a','e','i','o','u'};
            for(int i=0; i<newWord.length(); i++){
                for(int j=0; j<5; j++){
                    if(check[j]==newWord.charAt(i)){
                        a++;
                        break;
                    }
                }
            }

            if(a>0 && L-a>1) System.out.println(sb.toString());
            return;
        }
        for(int i=x; i<C; i++){
            if((visited & 1<<i) == 0){
                sb.append(codes[i]);
                permutation(depth+1, visited | 1<<i,i);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }



}
