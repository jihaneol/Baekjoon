import java.util.Scanner;

public class Main{
    private static int[] abc = new int[3];
    private static boolean[][][][][] dp;
    private static String str;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        char[] data = str.toCharArray();
        for (char d : data) {
            abc[d - 'A']++;
        }
        dp = new boolean[abc[0]+1][abc[1]+1][abc[2]+1][3][3];
        dfs("", 0, 0, 0);

        System.out.println(-1);
    }

    public static void dfs(String sb, int depth, int pre, int pre2) {

        if (dp[abc[0]][abc[1]][abc[2]][pre][pre2]) return;
        dp[abc[0]][abc[1]][abc[2]][pre][pre2] = true;
        if (str.length() == depth) {
            System.out.println(sb.toString());
            System.exit(0);
        }

        if (abc[0] > 0) {
            abc[0]--;
            dfs(sb + "A", depth + 1, 0, pre);
            abc[0]++;
        }
        if (abc[1] > 0 && pre != 1) {
            abc[1]--;
            dfs(sb + "B", depth + 1, 1, pre);

            abc[1]++;
        }
        if (abc[2] > 0 && pre != 2 && pre2 != 2) {
            abc[2]--;

            dfs(sb + "C", depth + 1, 2, pre);

            abc[2]++;
        }
    }

}
