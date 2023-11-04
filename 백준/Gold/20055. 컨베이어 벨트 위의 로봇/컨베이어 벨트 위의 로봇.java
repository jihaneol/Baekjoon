

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main{

    static int N,K;
    static int[] belt;

    static boolean[] robot;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());
        belt = new int[2*N];
        robot = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2*N; i++){
            belt[i] = Integer.valueOf(st.nextToken());
        }

        int answer = 0;
        while(isOK()){
            // 컨베이어 돌리기 ... 와 이생각을 못하네
            int temp = belt[belt.length-1];
            for(int i=belt.length-1; i>0; i--){
                belt[i] = belt[i-1];
            }
            belt[0] = temp;
            // 로봇 돌리기.. 함꼐 ㄷㄷ
            for(int i=robot.length-1; i>0; i--){
                robot[i] = robot[i-1];
            }
            robot[0] = false;
            robot[N-1] = false;
            // 로봇 이동하기
            for(int i=N-1; i>0; i--){
                if(robot[i-1] && !robot[i] && belt[i]>=1){
                    robot[i] = true;
                    robot[i-1] = false;
                    belt[i]--;
                }
            }
            if(belt[0]>0){
                robot[0] = true;
                belt[0]--;
            }
            answer++;

        }
        System.out.println(answer);
    }
    public static boolean isOK() {
        int cnt = 0;

        for (int i = 0; i < belt.length; i++) {
            if (belt[i] == 0) {
                cnt++;
            }
            if (cnt >= K) {
                return false;
            }
        }
        return true;
    }
}
