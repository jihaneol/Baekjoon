import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] scoreBoard;
    static int[][] nowScoreBoard;

    static int[][] players = {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6},
            {2, 3}, {2, 4}, {2, 5}, {2, 6},
            {3, 4}, {3, 5}, {3, 6},
            {4, 5}, {4, 6},
            {5, 6}};
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int game = 4;
        while (game-- > 0) {
            answer = 0;
            scoreBoard = new int[7][3];
            nowScoreBoard = new int[7][3];
            st = new StringTokenizer(br.readLine());
            // 값 초기화
            for (int i = 1; i < 7; i++) {
                for (int j = 0; j < 3; j++) {
                    scoreBoard[i][j] = Integer.valueOf(st.nextToken());
                }
            }

            // 경기 시작
            play(0);
            sb.append(answer).append(" ");
        }
        System.out.println(sb.toString());

    }

    private static void play(int cnt) {

        if(answer==1) return;
        if (cnt == 15 ) {
            if(!isPossible()) return;
            answer = 1;
            return;
        }
        int[] player = players[cnt];
        int A = player[0];
        int B = player[1];
        // 승
        if (scoreBoard[A][0] >= nowScoreBoard[A][0]+1 && scoreBoard[B][2] >= nowScoreBoard[B][2]+1) {
            nowScoreBoard[A][0]++;
            nowScoreBoard[B][2]++;
            play(cnt + 1);
            nowScoreBoard[A][0]--;
            nowScoreBoard[B][2]--;
        }
        // 무
        if (scoreBoard[A][1] >= nowScoreBoard[A][1]+1 && scoreBoard[B][1] >= nowScoreBoard[B][1]+1) {
            nowScoreBoard[A][1]++;
            nowScoreBoard[B][1]++;
            play(cnt + 1);
            nowScoreBoard[A][1]--;
            nowScoreBoard[B][1]--;
        }
        // 패
        if (scoreBoard[A][2] >= nowScoreBoard[A][2]+1 && scoreBoard[B][0] >= nowScoreBoard[B][0]+1) {
            nowScoreBoard[A][2]++;
            nowScoreBoard[B][0]++;
            play(cnt + 1);
            nowScoreBoard[A][2]--;
            nowScoreBoard[B][0]--;
        }

    }

    private static boolean isPossible() {
        for(int i=1; i<7; i++){
            int cnt = 0;
            for(int j=0; j<3; j++){
                cnt +=scoreBoard[i][j];
            }
            if(cnt!=5) return false;
        }
        return true;
    }
}