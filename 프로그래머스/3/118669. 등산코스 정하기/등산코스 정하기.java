import java.util.*;
class Solution {
    
    public class Node{
        int e, w;
        Node(int e, int w){
            this.e = e;
            this.w = w;
        }
    }
    private List<List<Node>> graph;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        
        graph = new ArrayList();
        
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList());
        }
        
        for(int[] path: paths){
            int s = path[0];
            int e = path[1];
            int w = path[2];
            
            // 핵심 도착지점과 출발지점은 단방향으로 
            if(isGate(s,gates) || isSummit(e,summits)){
                graph.get(s).add(new Node(e,w));
            }else if(isGate(e,gates) || isSummit(s,summits)){
                graph.get(e).add(new Node(s,w));
            }else{
                graph.get(s).add(new Node(e,w));
                graph.get(e).add(new Node(s,w));
            }
        }
        
        return dik(n, gates, summits);
    }
    public int[] dik(int n, int[] gates, int[] summits){
        Queue<Node> q = new LinkedList();
        int[] intensity = new int[n+1];
        
        Arrays.fill(intensity, 10000001);
        
        for(int gate : gates){
            q.add(new Node(gate,0));
            intensity[gate] = 0; //시작지점
        }
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(now.w > intensity[now.e]) continue;
            
            for(Node next : graph.get(now.e)){
                if(intensity[next.e] > Math.max(next.w, intensity[now.e])){
                    intensity[next.e] = Math.max(next.w, intensity[now.e]);
                    q.add(new Node(next.e,intensity[next.e]));
                }
            }
        }
        int in = 100000001; // 최솟값
        int summ = 50001; // 산봉우리
        
        Arrays.sort(summits);

        for (int summit : summits) {
            if (intensity[summit] < in) {
                summ = summit;
                in = intensity[summit];
            }
        }

        return new int[]{summ, in};
        
        
    }
    public boolean isGate(int n, int[] gates){
        for(int gate : gates){
            if(n == gate) return true;
        }
        return false;
    }
    public boolean isSummit(int n, int[] summit){
        for(int s: summit){
            if(n==s) return true;
        }
        return false;
    }
    
       
}