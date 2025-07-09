class Solution {
    private int[][] matrix;
    private int[][] dp;
    public int solution(int[][] matrix_sizes) {
        
        dp = new int[matrix_sizes.length][matrix_sizes.length];
        // ab, c or a, bc 둘중에 최소 곱셈 수 찾기
        matrix = matrix_sizes;
        int answer = divideConquer(matrix.length, 0, matrix.length-1);
        
        return answer;
    }
    public int divideConquer(int len, int s, int e){
        if(dp[s][e]!=0){
            return dp[s][e];
        }
        
        if(len==2){
            return dp[s][e] = matrix[s][0]*matrix[s][1]*matrix[e][1];
        }
        
        if(len==1){
            return 0;
        }
        
        // dp 있으면 갈 필요가 없다.
        
        int result = Integer.MAX_VALUE;
        // 분할
        for(int i=0; i<len-1; i++){
            int left = divideConquer(i+1, s, s+i);
            int right = divideConquer(len-i-1, s+i+1, e);

            // 정복 - 계산 하기
            //ab - dc
            int[] a = matrix[s];
            int[] b = matrix[s+i];
            int[] c = matrix[e];
           
            result = Math.min(result,left + right + a[0]*c[1]*b[1]);
        }
       
       
        return dp[s][e] = result;
    }
}