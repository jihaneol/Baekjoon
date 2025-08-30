import java.util.*;

class Solution {
    
    public Map<Integer, Queue<Integer>> tree = new HashMap();
    public List<Integer> route = new ArrayList();
    public int[] targetCnt;
    public int n;
    public int[] solution(int[][] edges, int[] target) {
        
        Arrays.sort(edges, (int[] a, int[] b) -> a[1]-b[1]);
        
        n = target.length;
        targetCnt = new int[n+1];
        for(int[] edge : edges){
            int s = edge[0];
            int e = edge[1];
            tree.computeIfAbsent(s, k -> new ArrayDeque()).add(e);
        }
        
        // 트리 방향 바꾸며 이동
        while(true){
            int leafNode = getLeafNode();
            targetCnt[leafNode]++;
            
            route.add(leafNode);
            int num = validate(target); // leaf 도달 가능한지.
            
            if(num==0){
                return new int[]{-1};
            }else if(num==1){
                break;
            }
            
        }
        
        // 사전 순으로 빠른 경우 구하기.
        
        int[] answer = new int[route.size()];
        
        for(int i=0; i<route.size(); i++){
            
            int node = route.get(i); // 현재 leaf node
            int sum = target[node-1]; // leaf에 쌓인 숫자 합
          
            int cnt = getCnt(sum,--targetCnt[node]); 
            answer[i] = cnt;
            target[node-1] -= cnt;
        }
        return answer;
    }
    
    // leaf 노드 구하기
    public int getLeafNode(){
        
        int node = 1;
        while(tree.containsKey(node)){
            Queue<Integer> q = tree.get(node);
            int next = q.poll();
            q.add(next);
            node = next;
        }
        
        return node;
    }
    // 0 불가능, 1 모두 가능, 2 계속 진행
    public int validate(int[] target){
        
        int result = 1;
        for(int i=0; i<n; i++){
            
            if(targetCnt[i+1]*3 < target[i]){
                result = 2;
            }
            
            if(target[i] < targetCnt[i+1]){
                return 0;
            }
        }
        
        return result;
    }
    public int getCnt(int sum, int cnt){
        // 1
        if(sum-1 <= cnt*3) return 1;
        // 2
        if(sum-2 <= cnt*3) return 2;
        // 3
        return 3;
    }
}


