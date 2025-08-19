class Solution {
    public static int solution(int[] stones, int k) {
        int left = 0;
        int right = 200000000;
        while(left < right){
            int mid = (left + right)/2;
            if(check(k,mid,stones)){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }

    public static boolean check(int k, int mid, int[] stones){
        int cnt = 0;
        int max = 0;
        for (int stone : stones) {
            int x = stone - mid;
            if(x <= 0){
                cnt++;
            }
            else{
                max = Math.max(max,cnt);
                cnt = 0;
            }
        }
        max = Math.max(max,cnt);
        if(max < k){
            return true;
        }
        return false;
    }

}