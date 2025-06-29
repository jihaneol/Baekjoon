import java.util.*;
class Solution {
    private static Map<Integer, Map<String, Integer>> courseMap;
    
    public String[] solution(String[] orders, int[] course) {
        courseMap = new HashMap();
        // 코스요리 개수 courseMap 채우기
        for(int c : course){
            courseMap.put(c, new HashMap());
        }
        
        
        // 주문에서 정렬하고 조합으로 코스 요리 수 만큼 map 채우기
        for(String order : orders){
            char[] orderArr = order.toCharArray();
            Arrays.sort(orderArr);
            combi(0, orderArr, "");
        }
        List<String> answer = new ArrayList();
        
        // courseMap에서 코스 종류별로 많이 주문된 메뉴 answer에 담기
        for(Map<String, Integer> count : courseMap.values()){
            count.values()
            .stream()
            .max(Comparator.comparingInt(o->o))
            .ifPresent(cnt -> count.entrySet().stream()
                       // 최소 2명 이상이 주문 && 가장 많이 주문
                       .filter(entry -> cnt>1 && cnt == entry.getValue())
                       .forEach(entry -> answer.add(entry.getKey()))
                      );
        }
        Collections.sort(answer);
       return answer.toArray(new String[0]);
        
    }
    public static void combi(int idx, char[] order, String result){
       // 코스 요리 개수와 같으면
        if(courseMap.containsKey(result.length())){
            Map<String, Integer> map = courseMap.get(result.length());
            map.put(result, map.getOrDefault(result,0)+1);
        }
        
        for(int i=idx; i<order.length; i++){
            combi(i+1, order, result + order[i]);
        }
    }
}