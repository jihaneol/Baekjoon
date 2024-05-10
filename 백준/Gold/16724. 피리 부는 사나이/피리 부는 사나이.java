
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n, m;

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static boolean[][] visited;

    static int[][] map, groupMap;

    static Stack<int[]> stack = new Stack<>();
    static int num;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        groupMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                int num = 0;
                switch (charArray[j]) {
                    case 'D':
                        num = 1;
                        break;
                    case 'L':
                        num = 2;
                        break;
                    case 'R':
                        num = 3;
                        break;
                }
                map[i][j] = num;
            }
        }

        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    visited[i][j]  =true;
                    solution(i,j);
                }
            }
        }


        System.out.println(num);


    }


    private static void solution(int x, int y) {
        stack.push(new int[] {x,y});

        while(true){
            int[] now = stack.peek();
            int d = map[now[0]][now[1]];
            int nx = now[0] + dir[d][0];
            int ny = now[1] + dir[d][1];

            if(groupMap[nx][ny] !=0){
                while(!stack.isEmpty()){
                    int[] s = stack.pop();
                    groupMap[s[0]][s[1]] = groupMap[nx][ny];
                }
                return;
            }

            if(visited[nx][ny]) break;
            visited[nx][ny] = true;
            stack.push(new int[] {nx,ny});
        }
        num++;
        while(!stack.isEmpty()){
            int[] now = stack.pop();

            groupMap[now[0]][now[1]] = num;

        }
    }


}