import java.util.*;

public class Main {

    static ArrayList<Long> list;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        list = new ArrayList<>();

        if(n <= 10) System.out.println(n);
        else {
            for(int i = 0; i < 10; i++) {
                bp(i, 1);
            }
            Collections.sort(list);

            if(list.size()<=n) System.out.println(-1);
            else System.out.println(list.get(n));
        }
    }

    public static void bp(long num, int idx) {
        if(idx > 10) return;

        list.add(num);
        for(int i = 0; i < num % 10; i++) {
            bp((num * 10) + i, idx + 1);
        }
    }
}