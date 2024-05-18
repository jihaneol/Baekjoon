import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	static StringBuilder sb;
	static int N1;
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		N1 = sc.nextInt();
		sb = new StringBuilder();
		sb.append((int)(Math.pow(2, N1)-1)+"\n");
		
		hanoi(N1, 1, 3, 2);
		
		System.out.println(sb.toString());
		
	}
	
	static void hanoi(int n, int from , int to , int temp) {
		if(n==1) {
			sb.append(from +" "+to +"\n");
			return ;
		}
		hanoi(n-1, from, temp, to); //1
		sb.append(from+ " " + to+"\n"); //2
		hanoi(n-1, temp, to, from);  //3
	}
}
