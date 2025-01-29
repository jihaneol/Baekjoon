import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String l1 = sc.nextLine();
        String l2 = sc.nextLine();
        String l3 = sc.nextLine();

        long answer = (oum.valueOf(l1).getNum()*10 + oum.valueOf(l2).getNum())*oum.valueOf(l3).getMult();
        System.out.println(answer);
    }
}

enum oum {
    black(0, 1),
    brown(1, 10),
    red(2, 100),
    orange(3, 1_000),
    yellow(4, 10_000),
    green(5, 100_000),
    blue(6, 1_000_000),
    violet(7, 10_000_000),
    grey(8, 100_000_000),
    white(9, 1_000_000_000);

    int num;
    long mult;

    oum(int num, long mult) {
        this.num = num;
        this.mult = mult;
    }

    int getNum() {
        return num;
    }

    long getMult() {
        return mult;
    }

 }