import java.util.*;
class Fail implements Comparable<Fail>{
    private int stage;
    private double rate;
    
    Fail(int s, double r){
        stage = s;
        rate = r;
    }
    
    public int getStage(){
        return stage; 
    }
    
    public int compareTo(Fail f){
        return Double.compare(f.rate, rate) == 0 ? Integer.compare(stage, f.stage) 
            : Double.compare(f.rate, rate);
    }
}
class Solution {
    public int[] solution(int N, int[] stages) {
   
        int[] failArr = new int[N+2];
        
        for(int stage : stages){
            failArr[stage]++;
        }
        
        List<Fail> list = new ArrayList();
        
        double len = stages.length;
        
        for(int i=1; i<=N; i++){
            
            int num = failArr[i];
        
            
            
            if(num==0){
                list.add(new Fail(i, 0.0));
            }
            else {
                list.add(new Fail(i, num/len));
                len -= failArr[i]; 
            }
            
        }
    
        Collections.sort(list);
        
        return list.stream().mapToInt(Fail :: getStage).toArray();
    }
}