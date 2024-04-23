import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	
	static class People implements Comparable<People>{
		int age;
		String name;
		int cnt;
		
		public People(int age, String name,int cnt) {
			super();
			this.age = age;
			this.name = name;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(People o) {
			return this.age!=o.age?this.age-o.age: this.cnt-o.cnt;
		}
		@Override
		public String toString() {
			return age +" " +name;
		}
		
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cnt=1;
		List<People> list = new ArrayList<>();
		int n = Integer.valueOf(br.readLine());
		while(n-->0) {
			st = new StringTokenizer(br.readLine());
			list.add(new People(Integer.valueOf(st.nextToken()), st.nextToken(), cnt));
			cnt++;
		}
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)+"\n");
		}
		
		System.out.println(sb.toString());
	}
}
