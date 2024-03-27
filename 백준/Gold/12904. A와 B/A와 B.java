import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.print.attribute.standard.Sides;

class Main {

	static StringTokenizer st;
	static BufferedReader br;
	static String S,T;
	static boolean check;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        boolean re = true;
        int start=0,end=T.length()-1;
        while(end-start+1>S.length()) {
        	char temp;
        	if(re) {
        		temp = T.charAt(end);        		
        	}else {
        		temp = T.charAt(start);        		
        		
        	}
        	if(temp=='A') {
        		if(re) {
        			end--;
        		}else {
        			start++;
        		}
        	}else {
        		if(re) {
        			end--;
        		}else {
        			start++;
        		}
        		re=!re;
        	}
        }
        String si = T.substring(start, end+1);
        StringBuffer sb = new StringBuffer(si);
        String temp = sb.reverse().toString();
        if(re) {
        	if(si.equals(S)) {
        		System.out.println(1);
        	}else {
        		System.out.println(0);
        	}
        }else {
        	
        	if(temp.equals(S)) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
        }
    }
}
	
