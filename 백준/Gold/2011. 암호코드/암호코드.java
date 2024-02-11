import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        final int MOD = 1000000;

        int length = num.length();
        int[][] dp = new int[length][2];

        if (num.charAt(0)=='0') {
            System.out.println(0);
            return;
        } else if (length == 1) {
            System.out.println(1);
            return;
        }
        dp[0][0] = 1;
        if (isCheckNumToCode(Integer.parseInt(num.substring(0, 2)))) {
            dp[1][1] = 1;
        }
        if (isCheckNumToCode(Integer.parseInt(num.substring(1, 2)))) {
            dp[1][0] = 1;
        }

        for (int i = 2; i < length; i++) {
            if (num.substring(i - 1, i + 1).equals("00")) {
                System.out.println(0);
                return;
            }
            if (!num.substring(i - 1, i).equals("0") && isCheckNumToCode(Integer.parseInt(num.substring(i - 1, i + 1)))) {
                dp[i][1] = (dp[i - 2][0] + dp[i - 2][1]) % MOD;
            }
            if (isCheckNumToCode(Integer.parseInt(num.substring(i, i + 1))))
                dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }
        System.out.println((dp[length - 1][0] + dp[length - 1][1]) % MOD);
    }

    public static boolean isCheckNumToCode(int num) {
        return num >= 1 && num <= 26;
    }
}