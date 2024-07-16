import java.util.*;

public class Main {
    private static int n;
    private static int[] data;
    private static boolean[] v;
    private static TreeSet<Integer> set = new TreeSet<>();

    public static void main(String[] args) {
        init();
        solve();
    }
    public static void init(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        data = new int[n+1];
        v = new boolean[n+1];
        for(int i=1; i<=n; i++){
            data[i] =sc.nextInt();
        }
    }

    public static void solve(){

        for(int i=1; i<=n; i++){
            if(!set.contains(i)){
                dfs(data[i], i);
            }
        }

        System.out.println(set.size());
        for(int n : set){
            System.out.println(n);
        }
    }

    public static void dfs(int start, int target) {
        if(start==target) {
            set.add(start);
            return;
        }
        if(!v[data[start]]){
            v[data[start]] = true;
            dfs(data[start], target);
            v[data[start]] = false;
        }
    }
}