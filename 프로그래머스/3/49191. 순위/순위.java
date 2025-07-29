class Solution {

    public int solution(int n, int[][] results) {
        // 승패 관계를 저장하는 배열 (win[i][j] = i가 j를 이김)
        boolean[][] win = new boolean[n][n];

        // 초기 결과 입력
        for (int[] result : results) {
            win[result[0] - 1][result[1] - 1] = true;
        }

        // 플로이드-워셜로 승패 관계 전파
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (win[i][k] && win[k][j]) {
                        win[i][j] = true;
                    }
                }
            }
        }

        int count = 0;
        // 각 선수별로 이긴 수와 진 수를 계산
        for (int i = 0; i < n; i++) {
            int winCount = 0;
            int loseCount = 0;
            for (int j = 0; j < n; j++) {
                if (win[i][j]) winCount++;
                if (win[j][i]) loseCount++;
            }
            if (winCount + loseCount == n - 1) count++;
        }

        return count;
    }
}