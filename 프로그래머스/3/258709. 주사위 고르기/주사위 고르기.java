import java.util.*;
class Solution {
    public int n,result;
    public List<List<Integer>> diceComb = new ArrayList();
    public int[] solution(int[][] dice) {
        int[] answer = {};
        result = 0;
        n = dice.length;
        // 1. n/2개씩 주사위 분리하기
        divideDice(0,0, new ArrayList());
        // 2. 갖고 있는 모든 A,B 주사위의 모든 합 저장 6**5
        boolean[] choice = new boolean[n];
        for(List<Integer> A : diceComb){

            // B 뽑기
            for(int n : A){
                choice[n] = true;
            }
            List<Integer> B = new ArrayList();
            for(int i=0; i<n; i++){
                if(!choice[i])
                    B.add(i);
            }
            
            //A B 총합 구하기..
            List<Integer> totalA = new ArrayList();
            List<Integer> totalB = new ArrayList();

            getTotal(0,A,totalA,0,dice);
            getTotal(0,B,totalB,0,dice);
            
            Collections.sort(totalA);
            Collections.sort(totalB);
            
            // 이분 탐색
            int Awin = binarySearch(totalA,totalB);
  
            if(result<Awin){
                answer=A.stream().mapToInt(i -> i+1).toArray();
                result = Awin;
            }
            
            Arrays.fill(choice,false);
        }
        return answer;
        
    }
    public int binarySearch(List<Integer> A , List<Integer> B){
        int win = 0;
  
        for(int target : A){
            int e = B.size();
            int s = 0;
            while(s<e){
                int mid = (s+e)/2;
                if(target <=B.get(mid)){
                    e = mid;
                }else{
                    s = mid+1;
                }
            }
            win += e;
        }
        return win;
        
    }
    public void getTotal(int depth, List<Integer> dice, List<Integer> total,int sum,int[][] D){
        if(depth == n/2){
            total.add(sum);
            return;
        }
        int now = dice.get(depth);
        for(int i=0; i<6; i++){
            int num = D[now][i];
            getTotal(depth+1, dice, total, sum+num,D);
        }
        

    }
    public void divideDice(int idx,int depth, List<Integer> dice){
        if(depth==n/2){
            diceComb.add(new ArrayList(dice));
            return;
        }
        
        for(int i=idx; i<n; i++){
            dice.add(i);
            divideDice(i+1,depth+1 , dice);
            dice.remove(depth);
        }
    }
}