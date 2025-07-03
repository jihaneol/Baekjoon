class Solution {
    private int[] answer = new int[2]; // [0개수, 1개수]
    public int[] solution(int[][] arr) {
        // 재귀 하면서 쿼드 트리 압축
        compression(arr, 0,0,arr.length);
        return answer;
    }
    public void compression(int[][] arr, int x, int y, int len){
        int num = arr[x][y];
        // 1 X 1 일때
        if(len==1){ 
            answer[num]++;
            return;
        }
        boolean isPossible = true;
        // 현재 위치 압축 가능한지 확인하기
        end:for(int i=x; i<x+len; i++){
            for(int j=y; j<y+len; j++){
                // 압축 실패
                if(num!=arr[i][j]){
                    isPossible = false;
                    break end;        
                }
            }
        }
        
        // 압축 성공하면
        if(isPossible){
            answer[num]++;
            return;
        }else{
            // 1 사분면
            compression(arr, x , y, len/2);
            
            // 2 사분면
            compression(arr, x+len/2 ,y, len/2);
            
            // 3 사분면
            compression(arr, x+len/2 ,y+len/2, len/2);
            
            // 4 사분면
            compression(arr, x ,y+len/2, len/2);
        }
    }
}