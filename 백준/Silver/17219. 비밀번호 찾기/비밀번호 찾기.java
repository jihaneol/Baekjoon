

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        Map<String,String> map = new HashMap<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(),st.nextToken());
        }
        StringBuilder sb= new StringBuilder();
        for(int j=0; j<M; j++){
            st = new StringTokenizer(br.readLine());
            sb.append(map.get(st.nextToken())).append('\n');
        }
        System.out.println(sb.toString());
    }
}
