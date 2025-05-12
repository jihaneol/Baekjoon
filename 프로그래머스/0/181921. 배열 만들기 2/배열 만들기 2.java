import java.util.*;
class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList();
        makeArr(list, 5,l,r);
        
        list.sort((i,j) -> Integer.compare(i,j));
        
        return list.size()==0 ? new int[]{-1} 
        : list.stream().mapToInt(i->i).toArray();
    }
    private void makeArr(List<Integer> list, int now, int l, int r){
        if(now>r) return;
        
        if(l<=now && now<=r)
            list.add(now);
        
        if(now%10 == 0){
            makeArr(list, now+5, l, r);
        }
        makeArr(list, now*10, l, r);
    }
}