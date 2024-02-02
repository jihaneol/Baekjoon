import java.util.Scanner;
import java.util.stream.Stream;
import java.util.*;

public class Main {
	static int [] arr;
	static int sum=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 삽입 정렬
		
		for(int i=1; i<n; i++) {
		   int idx	= binarySearch(0, i, arr[i]);
		   
		   //  다 넘기기
		   int temp = arr[i];
		   for(int j=i; j>idx; j--) {
			   arr[j]=arr[j-1];
		   }
		   arr[idx]=temp;
		}
		int sdf=Arrays.stream(arr).reduce((a,b)->
		{
			sum+=a;
			return a+b;
		}
				).getAsInt();
		System.out.println(sum+sdf);
		
	}
	public static int binarySearch(int s, int e,int target) {
		int mid =0;
		while(s<e) {
			mid = (s+e)/2;
			
			if(arr[mid]>=target) {
				e=mid;
			}else {
				s=mid+1;
			}
		}
		return s;
	}
}
