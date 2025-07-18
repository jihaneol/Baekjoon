import java.util.*;
class Solution {
    
    public String[] solution(String[] expressions) {
     
        List<String> xList = new ArrayList();
        boolean[] isPossible = new boolean[10];
        Arrays.fill(isPossible, true);
        
        for(String expression : expressions){
            String[] split = expression.split(" = ");
            if("X".equals(split[1])){
                xList.add(split[0]);
            }
            for(int i=2; i<10; i++){
                if(!isPossible[i]) continue;
                try{
                    String[] op = split[0].split(" ");
                    int a = Integer.parseInt(op[0],i);
                    int b = Integer.parseInt(op[2],i);
                    if("X".equals(split[1])){
                        break;
                    }
                    int c = 0;
                    if("+".equals(op[1])){
                        c = a + b;
                    }else{
                        c = a - b;
                    }
                    
                    if(!split[1].equals(Integer.toString(c, i))){
                        isPossible[i] = false;
                    }
                    
                }catch(Exception e){
                    isPossible[i] = false;
                }    
            }
        }
        List<String> answer = new ArrayList();
       
        for(String exp : xList){
            String[] op = exp.split(" ");
            String x = null;
            Set<String> set = new HashSet();
            for(int i=2; i<10; i++){
                if(!isPossible[i]) continue;
                try{
                    int a = Integer.parseInt(op[0],i);
                    int b = Integer.parseInt(op[2],i);
                    int c = 0;
                    if("+".equals(op[1])){
                        c = a + b;
                    }else{
                        c = a - b;
                    }
                    x = Integer.toString(c, i);
                    set.add(x);
                }catch(Exception e){
                }    
                
                
            }
            
            if(set.size()==1){
                answer.add(exp+" = "+x);
            }else{
                answer.add(exp+" = ?");
            }
                
        }
    
        
        return answer.stream().toArray(String[]::new);
    }
    
}