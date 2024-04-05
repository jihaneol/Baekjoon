class Solution {
    int[] parents;
    public int solution(int n, int[][] wires) {
        int answer = 100;
        for(int i=0; i<n-1 ;i++){
            parents = new int[n+1];
            for(int c=1; c<=n; c++) parents[c] = c;
            for(int j=0; j<n-1; j++){
                if(i==j) continue;
                union(wires[j][0],wires[j][1]);
            }
            int a = 1;
            for(int target=2; target<=n; target++){
                if(find(1) == find(target)){
                    a++;
                }
            }
            answer = Math.min(Math.abs(a-n+a),answer);
        }
        
        return answer;
    }
    public int find(int x){
        if(parents[x]==x){
            return x;
        }
        
        return parents[x] = find(parents[x]);
    }
    
    public void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y) parents[x] = y;
    }
    
}