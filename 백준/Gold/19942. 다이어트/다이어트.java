import java.util.*;

public class Main {
    private static int[] checkList, selectlist;
    private static int[][] list;
    private static int cost, selectnum, n;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        checkList = new int[4];
        selectlist = new int[5];
        for (int i = 0; i < 4; i++) {
            checkList[i] = sc.nextInt();
        }
        list = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                list[i][j] = sc.nextInt();
            }
        }
        cost = 7501;
        backtraking(0, 0);
        if (selectnum == 0) {
            System.out.println(-1);
        }else{
            System.out.println(cost);
            for (int i = 0; i < n; i++) {
                if ((selectnum & 1 << i) != 0) {
                    System.out.print(i + 1 + " ");
                }
            }
        }
       
        

    }

    private static void backtraking(int x, int visited) {
        if (check()) {
            if (cost > selectlist[4]) {
                cost = selectlist[4];
                selectnum = visited;
            }
            return;
        }


        for (int i = x; i < n; i++) {
            if ((visited & 1 << i) == 0) {
                for (int j = 0; j < 5; j++) {
                    selectlist[j] += list[i][j];
                }
                backtraking(i + 1, visited | 1 << i);

                for (int j = 0; j < 5; j++) {
                    selectlist[j] -= list[i][j];
                }
            }
        }
    }

    private static boolean check() {
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            if (selectlist[i] < checkList[i]) {
                flag = false;
                break;
            }
        }
        return flag;
    }


}