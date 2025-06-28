import java.util.*;
class Solution {
    private static Map<Integer, Map<String, Integer>> courseMap;
    public String[] solution(String[] orders, int[] course) {
        
        courseMap = new HashMap();
        for(int i: course){
            courseMap.put(i, new HashMap());
        }
        
        for(String order:orders){
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray);
            combi(0, orderArray, "");
        }
        
        ArrayList<String> answer = new ArrayList();
        
        for(Map<String, Integer> count : courseMap.values()){
            count.values()
                .stream()
                .max(Comparator.comparingInt(o -> o))
                .ifPresent(cnt -> count.entrySet()
                          .stream()
                           .filter(entry -> cnt.equals(entry.getValue()) && cnt > 1).forEach(entry -> answer.add(entry.getKey()))
                );
                           
                          
        }
        Collections.sort(answer);
        return answer.toArray(new String[0]);
        
    }
    public static void combi(int idx, char[] order, String result){
        if(courseMap.containsKey(result.length())){
            Map<String, Integer> map = courseMap.get(result.length());
            map.put(result, map.getOrDefault(result, 0) + 1);
        }
        
        for(int i=idx; i< order.length; i++){
            // 0, abc , "" -> 1, abc, "a"
            combi(i+1, order, result+order[i]);
        }
    }
}