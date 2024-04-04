class Solution {
    int n, answer, cnt;
    boolean visited[];
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        cnt = 0;
        n = dungeons.length;
        visited = new boolean[n];
        permu(dungeons,0,k);
        return answer;
    }
    public void permu(int[][] dungeons, int depth, int k){
        if(depth == n){
            answer = Math.max(answer,cnt);
         
            return;
            
        }
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                  
                if(dungeons[i][0]<=k){
                  
                    cnt++;
                    permu(dungeons, depth+1, k-dungeons[i][1]);
                    cnt--;
                }else{
                    permu(dungeons, depth+1, k);
                }
                visited[i] = false;
            }
        }
    }
}