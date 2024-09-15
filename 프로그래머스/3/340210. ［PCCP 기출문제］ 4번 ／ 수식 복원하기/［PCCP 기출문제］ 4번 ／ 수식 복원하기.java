import java.util.*;
class Solution {
    private  Queue<Integer> bits = new LinkedList();
    private final String ERROR = "ERROR";
    public List<String> solution(String[] expressions) {
        List<String> answer = new ArrayList();
        List<String> xList = new ArrayList();
        for(int i=2; i<10; i++){
            bits.add(i);
        }
        for(String exp : expressions){
            String[] e = exp.split(" "); // 0 2 4
            if("X".equals(e[4])){
                xList.add(exp);
            }
            cal(e);
        }
        
        
        Set<String> set = new HashSet();
        String tmp = "";
        for(String exp : xList){
            String[] e = exp.split(" ");
            for(int bit : bits){
                tmp = getResult(bit,e);
                if(!tmp.equals(ERROR)){
                    set.add(tmp);
                }
            }
    
            exp = exp.substring(0,exp.length()-1);
            if(set.size()==1){
                answer.add(exp+tmp);
            }else{
                answer.add(exp+"?");
            }
            set.clear();     
        }
        
        return answer;
    }
    public void cal(String[] e){
        int size= bits.size();
        while(size-->0){
            int bit = bits.poll();
            String b =  getResult(bit,e);
            if(b.equals(ERROR)) continue;
            if(b.equals(e[4]) || "X".equals(e[4])){
                 bits.add(bit);
            }
        }
    }
    public String getResult(int bit,String[] e){
  
        try{
             int a;
             if("+".equals(e[1])){
                 a=Integer.parseInt(e[0],bit)+Integer.parseInt(e[2],bit);
             }else{
                 a=Integer.parseInt(e[0],bit)-Integer.parseInt(e[2],bit);
             }
             return Integer.toString(a,bit);
        }catch(Exception e1){
            return ERROR;
        }
     
    }
     
}