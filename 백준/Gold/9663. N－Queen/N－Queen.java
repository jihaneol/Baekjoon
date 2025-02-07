import java.util.Scanner;

public class Main {
    private static boolean[] arr_c;
    private static boolean[][] board;
    private static int n;
    private static int answer;
    private static boolean[] diagonalR, diagonalL;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr_c = new boolean[n];
        diagonalR = new boolean[n*2];
        diagonalL = new boolean[n*2];

        back(0);
        System.out.println(answer);
    }

    private static void back(int row) {
        if (row == n) {
            answer++;
            return;
        }

        for(int col = 0; col < n; col++) {
            if(arr_c[col] || isDiagonal(row,col)) continue;
                arr_c[col] = true;
                diagonalR[row+col] = true;
                diagonalL[row-col+n] = true;
                back(row+1);
                arr_c[col] = false;
                diagonalR[row+col] = false;
                diagonalL[row-col+n] = false;
            }
        }

    private static boolean isDiagonal(int row, int col) {
        return diagonalL[row-col+n] || diagonalR[row+col];
    }
}