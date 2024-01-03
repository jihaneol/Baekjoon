import java.util.*;
class Solution {
    
    public List solution(long[] numbers) {
        List<Integer> answer = new ArrayList();
        
        for(long number : numbers){
            String s = Long.toBinaryString(number);
            int i = 0;
            while(Math.pow(2,i)-1 < s.length()) i++;
            while(Math.pow(2,i)-1 != s.length()) s = '0' + s;
            if(check(s)){
                answer.add(1);
            }else{
                answer.add(0);
            }
        }
        return answer;
    }
    
    
    private boolean check(String number){
        boolean valid = true;
		
		int mid = (number.length()-1)/2;
		char root = number.charAt(mid);
		String left = number.substring(0,mid);
		String right = number.substring(mid+1,number.length());
		
		if(root == '0' && (left.charAt((left.length()-1)/2)=='1' || right.charAt((right.length()-1)/2)=='1')){
			return false;
		}
		
		if(left.length() >= 3) {
			valid = check(left);
			if(valid) {
				valid = check(right);
			}
		}
		return valid;
        
    }
}