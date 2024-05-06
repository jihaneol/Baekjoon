import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static class Dia{
        int m,v;

        Dia(int m, int v){
            this.m = m;
            this.v = v;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer  = 0;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Dia[] diaArr = new Dia[n];
        int[] begM = new int[k];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            diaArr[i] = new Dia(m,v);
        }

        for(int i=0; i<k; i++){
            begM[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(diaArr, (Dia a, Dia b) -> {
            return Integer.compare(a.m,b.m);
        });
        PriorityQueue<Dia> pq = new PriorityQueue<>((a,b) -> {
            return Integer.compare(b.v,a.v);
        });

        int idx = 0;

        Arrays.sort(begM);


        for(int beg : begM){

            while(idx<n && beg>= diaArr[idx].m){
                pq.add(diaArr[idx++]);
            }

            if(!pq.isEmpty())
            answer += pq.poll().v;

        }
        System.out.println(answer);
    }

}