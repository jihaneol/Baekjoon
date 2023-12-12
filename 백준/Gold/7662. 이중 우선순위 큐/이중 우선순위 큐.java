import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = null;
    	StringBuilder sb = new StringBuilder();
    	int test = Integer.valueOf(br.readLine());
    	while(test-->0) {
    		int n = Integer.valueOf(br.readLine());
    		int num = 0;
    		TreeMap<Integer, Integer> tree = new TreeMap<>();
    		while(n-->0) {
    			st = new StringTokenizer(br.readLine());
    			if(st.nextToken().equals("I")) {
    				num = Integer.valueOf(st.nextToken());
    				tree.put(num, tree.getOrDefault(num, 0)+1); // 동시성 처리 부분
    				
    				
    			}else {
    				num = Integer.valueOf(st.nextToken());
    				if(tree.isEmpty()) {
    					continue;
    				}
    				if(num==-1) { // -1 이면 최솟값
    					 int minK = tree.firstKey();
    					 if(tree.get(minK)==1) {
    						 tree.remove(minK);
    					 }else {
    						 tree.put(minK, tree.get(minK)-1);
    					 }
    				}else {
    					int maxK = tree.lastKey();
						 if(tree.get(maxK)==1) {
							 tree.remove(maxK);
						 }else {
							 tree.put(maxK, tree.get(maxK)-1);
						 }
    				}
    				
    			}
    			
    		}
    		if(tree.isEmpty()) {
    			sb.append("EMPTY\n");
    		}else {
    			sb.append(tree.lastKey()+" "+tree.firstKey()+"\n");
    			
    		}
    		
    	}
    		
    	System.out.println(sb.toString());
    	
    	
    }   
}






