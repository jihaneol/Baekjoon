import java.util.*;

// v1
class Solution {

    private int n;
    private boolean[] visited;
    private List<int[]> diceComb;

    private List<Integer> scoreA;
    private List<Integer> scoreB;

    public int[] solution(int[][] dice) {
         n = dice.length;
        int[] answer = new int[n / 2];

        visited = new boolean[n];
        diceComb = new ArrayList<>();

        // 1. A가 뽑을 수 있는 주사위 조합 구하기
        permutation(0, 0, new int[n / 2]);

        // 2. 주사위 조합 별로 승률 계산
        int max = 0;
        for (int[] combA : diceComb) {
            int[] combB = new int[n / 2];
            boolean[] other = new boolean[n];

            int index = 0;
            for (int choice : combA) {
                other[choice-1] = true;
            }

            for (int i = 0; i < other.length; i++) {
                if (!other[i]) {
                    combB[index++] = i+1;
                }
            }

            scoreA = new ArrayList<>(); // A가 선택한 주사위의 모든 조합
            scoreB = new ArrayList<>(); // B가 선택한 주사위의 모든 조합

            combDice(0, combA, dice, 0, scoreA);
            combDice(0, combB, dice, 0, scoreB);

            Collections.sort(scoreA);
            Collections.sort(scoreB);

            // 3. 이분탐색으로 승리 카운트 찾는다
            int totalWinCount = 0;

            // 3. 이분탐색으로 승리 카운트 찾는다
            for (Integer a : scoreA) {
                int left = 0;
                int right = scoreB.size();

                while (left + 1 < right) {
                    int mid = (left + right) / 2;

                    if (a > scoreB.get(mid)) {
                        left = mid;
                    } else {
                        right = mid;
                    }
                }

                totalWinCount += left;
            }

            if (totalWinCount > max) {
                max = totalWinCount;
                answer = combA;
            }

        }

        return answer;
    }

    public void combDice(int index, int[] dices, int[][] originDices, int sum, List<Integer> team) {
        if (index == dices.length) {
            team.add(sum);
            return;
        }

        for (int i = 0; i < 6; i++) {
            combDice(index + 1, dices, originDices, sum + originDices[dices[index]-1][i], team);
        }
    }

    public void permutation(int depth, int index, int[] arr) {
        if (depth == n / 2) {
            diceComb.add(arr.clone());
            return;
        }
        for (int i = index; i < n; i++) {
            arr[depth] = i+1;
            permutation(depth + 1, i + 1, arr);
        }
    }
}