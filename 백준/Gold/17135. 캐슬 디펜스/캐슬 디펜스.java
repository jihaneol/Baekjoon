import java.io.*;
import java.util.*;

public class Main {
    private static int N,M,D,archer[],map[][],temp[][],answer;
    private static Set<Enemy> enemy;
    private static class Enemy{
        int x, y;

        Enemy(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) return true;
            if(obj == null || getClass()!=obj.getClass()) return false;
            Enemy e = (Enemy) obj;

            return x == e.x && y == e.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x,y);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.valueOf(s[0]);
        M = Integer.valueOf(s[1]);
        D = Integer.valueOf(s[2]);
        archer = new int[M];
        map = new int[N][M];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j]=Integer.valueOf(st.nextToken());
            }
        }
        createArcher(0, 0);
        System.out.println(answer);
    }
    private static void createArcher(int idx,int depth) { // 궁수 뽑기
        if(depth==3) {
            game();
            return;
        }
        for(int i=idx; i<M; i++) {
            archer[i]=1;
            createArcher(i+1, depth+1);
            archer[i]=0;
            if(depth==0 && M-3==i) return;
        }
    }
    private static void game() { // 게임 시작
        temp=new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                temp[i][j]= map[i][j];
            }
        }
        int result = 0;
        for(int ArcherRow = N; ArcherRow>0; ArcherRow--) {
            enemy = new HashSet<>();
            for(int ArcherCol = 0; ArcherCol<M; ArcherCol++) {
                if(archer[ArcherCol]==1) {
                    // 궁수 위치에서 적 쏜다. 동시에 공격한다.
                    shoot(ArcherRow, ArcherCol);
                }
            }
            result += enemy.size();

            for(Enemy e : enemy){
                temp[e.x][e.y]=0;
            }
        }

        if(answer<result){
            answer=result;
        }
    }
    private static void shoot(int row,int col) { //궁수 위치;
        for(int distance = 1; distance<=D; distance++) {
            for(int c = 1-distance; c<=distance-1; c++){
                int enemyRow;
                int enemyCol;
                if(c<=0){
                    enemyRow = row-(distance+c);
                    enemyCol = col + c;
                }else{
                    enemyRow = row-(distance-c);
                    enemyCol = col + c;
                }

                if(enemyRow<0 || enemyCol<0 ||enemyCol>=M) continue;

                if(temp[enemyRow][enemyCol]==1) {
                    enemy.add(new Enemy(enemyRow, enemyCol));
                    return;
                }
            }
        }

    }
}