import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n ;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int s = 0;
        int e = 0;
        int sum = 0;
        final int INF = 100_001;
        int answer = INF;

        while(e<=n){

            if(sum < target){
                sum += arr[e++];
            }else{
                answer = Math.min(answer, e - s);
                sum -= arr[s++];

            }

        }

        if(answer == INF){
            System.out.println(0);
        }else{
            System.out.println(answer);
        }





    }

}