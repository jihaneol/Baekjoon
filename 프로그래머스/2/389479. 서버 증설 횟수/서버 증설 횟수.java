class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] servers = new int[players.length+k+1];
        for(int i=0; i<players.length; i++){
            int player = players[i]; // 현재 인원
            int n = servers[i]*m + m; // 현재 감당 가능한 인원.
            if(player >= n){
                // 증설 개수
                int scale = ((player-n)/m+1);
                for(int j=i; j<i+k; j++){
                    // 필요한 서버수
                    servers[j] += scale;
                }
                answer+=scale;
            }
            
        }
        return answer;
    }
}