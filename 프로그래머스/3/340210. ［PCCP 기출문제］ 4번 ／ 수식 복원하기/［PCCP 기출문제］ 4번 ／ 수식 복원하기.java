import java.util.*;
class Solution {
    public List<String> solution(String[] expressions) {
        List<String> answer = new ArrayList();
        Queue<Integer> notation = findNotation(expressions);
        // x 인 수식들 계산 //100
        for(String exp : expressions){

            String[] temp = exp.split("=");
            String target = temp[1].strip();
            if(!target.equals("X")) continue;
            String[] nums = null;
            int size = notation.size();
            int sum = 0;
            boolean flag = false;
            Stack<String> result = new Stack();
            for(int no : notation){
                if(temp[0].contains("+")){
                    nums = temp[0].split("\\+");
                    sum =Integer.parseInt(nums[0].trim(),no)+Integer.parseInt(nums[1].trim(),no);

                }else{
                    nums = temp[0].split("\\-");
                    sum =Integer.parseInt(nums[0].trim(),no)-Integer.parseInt(nums[1].trim(),no);
                }
                if(!result.isEmpty() && !result.peek().equals(Integer.toString(sum,no))){
                    flag = true;
                }
                result.push(Integer.toString(sum,no));
                
            }
            String tmp;
            if(flag){
                tmp = exp.substring(0,exp.length()-1) + "?";
            }else{
                tmp = exp.substring(0,exp.length()-1) + result.peek();
            }
            
            answer.add(tmp);
        }
        
        
        return answer;
    }
    public Queue<Integer> findNotation(String[] expressions){
     
        Queue<Integer> notation = new LinkedList();
        for(int i =2; i<10; i++){
            notation.add(i);
        }
        // x 없는 수식들에서 진법 찾기.. //100
        for(String exp : expressions){

            String[] temp = exp.split("=");
            String target = temp[1].strip();
            String[] nums = null;
            int size = notation.size();
            for(int i=0; i<size; i++){
                int no = notation.poll();
                int sum = 0;
                try{
                    if(temp[0].contains("+")){
                        nums = temp[0].split("\\+");
                        sum =Integer.parseInt(nums[0].trim(),no)+Integer.parseInt(nums[1].trim(),no);
                   
                    }else{
                        nums = temp[0].split("\\-");
                        sum =Integer.parseInt(nums[0].trim(),no)-Integer.parseInt(nums[1].trim(),no);
                    }
                    if(target.equals("X")){
                        notation.add(no);
                    }else{
                        
                        if(target.equals(Integer.toString(sum,no))){
                            notation.add(no);
                        }
                    }
                    
                }catch(Exception e){
                    continue;
                }
                
            }       
        }
        
        return notation;
    }
     
}