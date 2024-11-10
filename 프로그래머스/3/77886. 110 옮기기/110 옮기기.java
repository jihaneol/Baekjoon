class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        StringBuilder sb = new StringBuilder();
        //110 빼오기
        for(int t=0; t<s.length; t++){
            String word = s[t];
            sb.setLength(0);
            int cnt = 0;
            for(int i=0; i<word.length(); i++){
                sb.append(word.charAt(i));
                if(sb.length()>2&&sb.substring(sb.length()-3).equals("110")){
                    sb.delete(sb.length()-3,sb.length());
                    cnt++;
                }
            }
            int idx = sb.lastIndexOf("0");
            while(cnt-->0){
                sb.insert(idx+1,"110");
            }
            answer[t] = sb.toString();
        }
        
        
        return answer;
    }
}