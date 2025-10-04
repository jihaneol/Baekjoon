import java.util.*;
class Solution {
    public String[] solution(String[] expressions) {
        List<String> xList = new ArrayList();
        boolean[] isPossible = new boolean[10];
        Arrays.fill(isPossible, true);
        
        for(String expression: expressions){
            
            String[] split = expression.split(" = ");
            if("X".equals(split[1])) {
                xList.add(split[0]);
            }
            String[] exp = split[0].split(" ");
            for(int i=2; i<10; i++){
                if(!isPossible[i]) continue;
                
                try{
                    int a = Integer.parseInt(exp[0],i);
                    int b = Integer.parseInt(exp[2],i);
                    int x = 0;
                    if("-".equals(exp[1])){
                        x = a - b;
                    }else{
                        x = a + b;
                    }
                    
                    if(!"X".equals(split[1]) && !split[1].equals(Integer.toString(x,i))){
                        isPossible[i] = false;
                    }
                    
                }catch(Exception e){
                    isPossible[i] = false;
                }
            }
            
        }
        List<String> answer = new ArrayList();
        
        for(String expression : xList){
            String[] exp = expression.split(" ");
            String result = null;
            Set<String> set = new HashSet();
            for(int i=2; i<10; i++){
                if(!isPossible[i]) continue;
                
                try{
                    int a = Integer.parseInt(exp[0],i);
                    int b = Integer.parseInt(exp[2],i);
                    int x = 0;
                    if("-".equals(exp[1])){
                        x = a - b;
                    }else{
                        x = a + b;
                    }
                    result = Integer.toString(x,i);
                    set.add(result);
                    // System.out.println(i+" "+result);
                    
                }catch(Exception e){
                }
            }
            
            System.out.println("d");
            if(set.size()==1){
                answer.add(expression+" = "+result);
            }else{
                answer.add(expression+" = ?");
            }
        }
        
        
        return answer.stream().toArray(String[]::new);
    }
}