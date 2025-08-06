import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Node{
        int line;
        int value; // 컵라면
        Node(int line, int value) {
            this.line = line;
            this.value = value;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            nodes.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(nodes, (a,b) -> {
            return Integer.compare(a.line, b.line);
        });

        PriorityQueue<Node> pq = new PriorityQueue<>( (a, b) -> {
            return  Integer.compare(a.value, b.value);
        }
        );

        for(Node node : nodes) {
            int max_size = node.line;

            if(max_size > pq.size()) {
                pq.add(node);
            }else{
                Node min_node=  pq.peek(); // 현재 담긴 최소 노드
                if(min_node.value < node.value) {
                   pq.poll();
                   pq.add(node);
                }
            }
        }
        // 합치기
        int answer = 0;
        while(!pq.isEmpty()) {
           answer += pq.poll().value;
        }

        System.out.println(answer);

    }
}