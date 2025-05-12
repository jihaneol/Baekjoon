class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int num = 1;
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        
        while(rowStart<=rowEnd && colStart<=colEnd){
            // 위
            for(int y=colStart; y<=colEnd; y++){
                answer[rowStart][y] = num++;
            }
            rowStart++;
            // 오른쪽
            for(int x=rowStart; x<=rowEnd; x++){
                answer[x][colEnd] = num++;
            }
            colEnd--;
            // 아래쪽
            for(int y=colEnd; y>=colStart; y--){
                answer[rowEnd][y] = num++;
            }
            rowEnd--;
            // 왼쪽
            for(int x=rowEnd; x>=rowStart; x--){
                answer[x][colStart] = num++;
            }
            colStart++;
        }
        
        
        return answer;
    }
}