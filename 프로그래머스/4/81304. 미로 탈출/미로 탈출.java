import java.util.*;
class Solution {
    class Node {
        int vertex;
        int value;
        int trapBit;
        Node(int vertex, int value, int trapBit){
            this.vertex = vertex;
            this.value = value;
            this.trapBit = trapBit;
        }
    }
    
    class Edge{
        int vertex;
        int value;
        boolean isReverse; 
        Edge(int vertex, int value, boolean isReverse){
            this.vertex = vertex;
            this.value = value;
            this.isReverse = isReverse;
        }
        

    }
    private List<Edge>[] tree;
    private Map<Integer, Integer> trapIndex = new HashMap();
    private boolean[][] visited; // [노드번호][bit];
    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int answer = 0;
        init(n, roads, traps);
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> {
            return Integer.compare(a.value, b.value);
        });
        
        pq.add(new Node(start, 0, 0));
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            int vertex = now.vertex;
            int value = now.value;
            int trapBit = now.trapBit;
   
            if(vertex==end){
                answer = value;
                break;
            }
            if(visited[vertex][trapBit]) continue;
            visited[vertex][trapBit] = true;
            
            int flag = 0; // 방향 확인용
            
            // 현재 위치가 trap이라면 발동이 되었는지 확인
            if(trapIndex.containsKey(vertex)){
                int idx = trapIndex.get(vertex);
                trapBit = (trapBit ^ (1<<idx));
                
                if((trapBit & (1<<idx))!=0) flag += 1;
            }
            
            for(Edge next : tree[vertex]){
                int nextFlag = flag;
                // 다음 위치
                if(trapIndex.containsKey(next.vertex)){
                    int idx = trapIndex.get(next.vertex);
                   
                    if((trapBit & (1<<idx))!=0) nextFlag += 1;
                }
                
                // 역방향 이고 flag == 1
                if(next.isReverse && nextFlag==1 || 
                   (!next.isReverse && (nextFlag==0 || nextFlag ==2)))
                {
                    pq.add(new Node(next.vertex, value + next.value, trapBit));
                }
                
            }
        }
        
        return answer;
    }
    private void init(int n, int[][] roads, int[] traps){
        for(int i=0; i<traps.length; i++){
            trapIndex.put(traps[i], i);
        }
        visited = new boolean[n+1][1<<10];
        
        tree = new List[n+1];
        for(int i=0; i<=n; i++){
            tree[i] = new ArrayList();
        }
        
        for(int[] road : roads){
            int s = road[0];
            int e = road[1];
            int v = road[2];
            
            tree[s].add(new Edge(e,v,false));
            tree[e].add(new Edge(s,v,true));
        }
    }
}