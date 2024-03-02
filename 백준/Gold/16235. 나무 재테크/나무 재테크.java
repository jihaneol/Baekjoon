import java.io.*;
import java.util.*;


public class Main {
    static int[][] map, A;
    static int N, M, K;

    static Deque<Tree> deathtree, temptree, livetree;


    static class Tree {
        int x, y, age;

        Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        A = new int[N + 1][N + 1];

        deathtree = new ArrayDeque<>();
        temptree = new ArrayDeque<>();
        livetree = new ArrayDeque<>();


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            livetree.add(new Tree(x, y, z));
        }

        int[][] dir = {{1, 1}, {1, 0}, {1, -1}, {0, 1}, {0, -1}, {-1, 0}, {-1, 1}, {-1, -1}};
        while (K-- > 0) {
            //봄
            while (!livetree.isEmpty()) {
                Tree now = livetree.poll();
                if (map[now.x][now.y] < now.age) {
                    deathtree.add(now);
                } else {
                    map[now.x][now.y] -= now.age;
                    now.age++;
                    temptree.add(now);
                }
            }

            //여름
            while (!deathtree.isEmpty()) {
                Tree now = deathtree.poll();
                map[now.x][now.y] += (now.age / 2);
            }
            //가을
            while (!temptree.isEmpty()) {
                Tree now = temptree.poll();
                if (now.age % 5 == 0) {
                    for (int i = 0; i < 8; i++) {
                        int nx = now.x + dir[i][0];
                        int ny = now.y + dir[i][1];

                        if (nx <= 0 || ny <= 0 || nx > N || ny > N) continue;

                        livetree.addFirst(new Tree(nx, ny, 1));
                    }
                }
                livetree.add(now);
            }
            //겨울
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    map[i][j] += A[i][j];
                }
            }
        }

        System.out.println(livetree.size());
    }
}