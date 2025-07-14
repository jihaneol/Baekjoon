import java.util.*;
class Solution {
    // treeMap 사용
    
    // PriorityQueue 2개 사용
    class DublePQ{
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        private Map<Integer, Integer> countMap = new HashMap();
        private int size = 0;
        
        
        public int size(){
            return this.size;
        }
        public void add(int num){
            maxHeap.add(num);
            minHeap.add(num);
            countMap.put(num, countMap.getOrDefault(num, 0)+1);
            size++;
        }
        private Integer peek(PriorityQueue<Integer> pq){
            while(!pq.isEmpty()){
                int peek = pq.peek();
                if(countMap.get(peek)>0){
                    return peek;
                }else{
                    pq.poll();
                }
            }
            return null;
        }
        
        public Integer maxPeek(){
            return peek(maxHeap);
        }
        public Integer minPeek(){
            return peek(minHeap);
        }
        private void delete(PriorityQueue<Integer> pq){
            while(!pq.isEmpty()){
               int num = pq.poll();
                if(countMap.get(num)>0){
                    countMap.put(num, countMap.get(num)-1);
                    size--;
                    break;
                }
            }
        }
        public void maxDelete(){
            delete(maxHeap);
        }
        public void minDelete(){
            delete(minHeap);
        }
        
    }
    public int[] solution(String[] operations) {
        int[] answer = {};
        DublePQ pq = new DublePQ();
        for(String op : operations){
            String[] comm = op.split(" ");
            int num = Integer.parseInt(comm[1]);
            if("I".equals(comm[0])){
                pq.add(num);
            }else{
                if(num==1){
                    pq.maxDelete();
                }
                else{
                    pq.minDelete();
                }
            }
        }
        
        return pq.size()==0 ? new int[]{0, 0} : new int[]{pq.maxPeek(), pq.minPeek()};
    }
}