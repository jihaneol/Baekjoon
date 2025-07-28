class Solution {
    public int solution(int[] a) {
        int answer = 2;
        // 1. 좌, 우에서 가장 작은 번호 선택
        // 2. 내가 선택한 수와 좌, 우 비교해서 선택한 수보다 작은 횟수가 2개면 불가능

        int n = a.length;
        int[] rights = new int[a.length];  // 오른쪽 가장 작은 수 모음
        int[] lefts = new int[a.length];  // 왼쪽 가장 작은 수 모음
        rights[n-1] = a[n-1];
        lefts[0] = a[0];
        for(int i=n-2; i>=0; i--){
            rights[i] = a[i] > rights[i+1] ? rights[i+1] : a[i]; 
        }
        for(int i=1; i<n; i++){
            lefts[i] = a[i] > lefts[i-1] ? lefts[i-1] : a[i];
        }
        
        for(int i=1; i<a.length-1; i++){
            int mid = a[i];
            int right = rights[i+1];
            int left = lefts[i-1];
            // 비교 하기.
            if(mid<right || mid < left){
                answer++;
            }
        }
        

        
        return answer;
    }
}