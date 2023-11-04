
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] tap;
    static boolean[] used=new boolean[101];
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.valueOf(s[0]);
        M = Integer.valueOf(s[1]);
        tap = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            tap[i] = Integer.valueOf(st.nextToken());
        }
        int put=0;
        for(int i=0; i<M; i++) {
            int temp = tap[i];
            if(!used[temp]) { // 사용안하는 중
                if(put<N){
                    used[temp]=true;// 콘서트가 꽃을 공간이 있는경우
                    put++;

                }else { // 꽃을 공간이 없다.
                    find(i, temp);
                }
            }
        }
        System.out.println(answer);
    }
    public static void find(int idx,int num) {
        boolean[] temp = new boolean[101]; //현재 꽃힌 콘센트 중에 나중에 사용되는지 확인용
        int c = 0;
        int later_product = 0;
        for(int i=idx+1; i<M; i++) {
            if (used[tap[i]] && !temp[tap[i]]) {
                temp[tap[i]]=true;
                later_product = tap[i];
                c++;
            }
        }
        if(c==N) { // 다 사용된다면. 가장 늦게 사용되는 물건 제거
            used[later_product] = false;
        }else { // 부분 사용 된다면 안 사용되는 아무거나 제거
            for(int i=1; i<101; i++) {
                if(used[i] && !temp[i]) {
                    used[i]=false;
                    break;
                }
            }
        }
        used[num] = true;
        answer++;
    }
}