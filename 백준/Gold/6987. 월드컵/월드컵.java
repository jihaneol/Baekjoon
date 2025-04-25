import java.io.*;
import java.util.*;

public class Main {

    private static int[][] teams = new int[6][3]; // 6팀 승 무 패
    private static int[][] rounds = {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5},
            {1, 2}, {1, 3}, {1, 4}, {1, 5},
            {2, 3}, {2, 4}, {2, 5},
            {3, 4}, {3, 5},
            {4, 5}};

    private static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int z = 0; z < 4; z++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 값 초기화
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    teams[i][j] = Integer.valueOf(st.nextToken());
                }
            }
            answer = 0;
            play(0);
            sb.append(answer).append(" ");
        }
        System.out.println(sb.toString());

    }

    private static void play(int round) {
        if (answer == 1) return;
        if (round == rounds.length) {
            for (int i = 0; i < teams.length; i++) {
                for (int j = 0; j < teams[i].length; j++) {
                    if (teams[i][j] != 0) {
                        return;
                    }
                }
            }
            answer = 1;
            return;
        }

        int a = rounds[round][0];
        int b = rounds[round][1];
        // 승
        if (teams[a][0] - 1 >= 0 && teams[b][2] - 1 >= 0) {
            teams[a][0]--;
            teams[b][2]--;
            // 다음
            play(round + 1);
            teams[a][0]++;
            teams[b][2]++;

        }

        // 무
        if (teams[a][1] - 1 >= 0 && teams[b][1] - 1 >= 0) {
            teams[a][1]--;
            teams[b][1]--;
            // 다음
            play(round + 1);
            teams[a][1]++;
            teams[b][1]++;

        }
        // 패
        if (teams[a][2] - 1 >= 0 && teams[b][0] - 1 >= 0) {
            teams[a][2]--;
            teams[b][0]--;
            // 다음
            play(round + 1);
            teams[a][2]++;
            teams[b][0]++;

        }
    }

}