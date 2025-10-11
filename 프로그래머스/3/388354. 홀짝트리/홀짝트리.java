import java.util.*;
class Solution {
    class Visitor {
        int reverse;
        int evenOdd;
        
        public void addTreeType(int curv, int edgeCnt)
        {
            if((curv+edgeCnt)%2==0) evenOdd++;
            else reverse++;
        }
        
        public void calcuAnswer()
        {
            if(evenOdd==1) answer[0]++;
            if(reverse==1) answer[1]++;
        }
    }
    
    private int[] answer = new int[2];
    private Set<Integer> visited = new HashSet();
    private Map<Integer, List<Integer>> treeMap = new HashMap();
    
    public int[] solution(int[] nodes, int[][] edges) {
     
        for(int[] edge : edges)
        {
            treeMap.computeIfAbsent(edge[0], (k) -> new ArrayList()).add(edge[1]);   
            treeMap.computeIfAbsent(edge[1], (k) -> new ArrayList()).add(edge[0]);   
        }
        
        for(int node : nodes)
        {
            if(visited.contains(node)) continue;
         
            if(treeMap.get(node)==null) treeMap.put(node, new ArrayList());
            
            visited.add(node);
            Visitor visitor = new Visitor();
            
            dfs(node, visitor);
            
            visitor.calcuAnswer();
        }
        
        return answer;
    }
    
    private void dfs(int curv, Visitor visitor)
    {
        
        int edgeCnt = 0;
        
        for(int nextv : treeMap.get(curv))
        {
            edgeCnt++;
            
            if(visited.contains(nextv)) continue;
            
            visited.add(nextv);
            dfs(nextv, visitor);
        }
        
        visitor.addTreeType(curv, edgeCnt);
    }
}