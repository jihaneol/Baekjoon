import java.util.*;
class Solution {
    
    public String[] solution(String[] expressions) {
        List<Integer> radixList = new ArrayList();
        for(int base = 2; base<10; base++){
            if(validate(expressions, base)){
                radixList.add(base);
            }
        }
        List<String> answer = new ArrayList();
        for(String expression : expressions){
            String[] split = expression.split("=");
            
            if("X".equals(split[1].trim())){
                
                Set<String> radixSet = new HashSet();
                String[] exp = split[0].split(" ");
                String res = "";
                for(int base : radixList){
                    res = Integer.toString(calcu(exp, base),base);
                    radixSet.add(res);
                  
                }
       
                if(radixSet.size()==1){
                    answer.add(split[0]+"= "+res);
                }else{
                    answer.add(split[0]+"= ?");
                }
                
            }
        }
        
        return answer.stream().toArray(String[]::new);
    }
    private boolean validate(String[] expressions, int base){
        
        for(String expression : expressions){
            
            for(int i=0; i<expression.length(); i++){
                char c = expression.charAt(i);
                if(Character.isDigit(c) && base <= c -'0') return false;
            }
            
            String[] split = expression.split("=");
            String res = split[1].trim();
            
            if(!"X".equals(res)){
                int target = calcu(split[0].split(" "), base);
                if(Integer.parseInt(res,base) != target) return false;
            }
        }
        return true;
    }
    private int calcu(String[] exp, int base){
        String a = exp[0];
        String op = exp[1];
        String b = exp[2];
        
        if("+".equals(op)){
            return Integer.parseInt(a, base) + Integer.parseInt(b,base);
        }else{
            return Integer.parseInt(a, base) - Integer.parseInt(b,base);
        }
    }
    
}