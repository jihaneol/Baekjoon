import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static class Root {
        int value;
        Root left, right;

        Root() {
            value = 0;
        }
        void push(int v) {
            if (value == 0) {
                this.value = v;
            } else if (value < v) {
                if(right == null)  right = new Root();
                right.push(v);
            }else{
                if(left==null) left = new Root();
                left.push(v);
            }
        }

        void get(){
            if(left != null) left.get();
            if(right !=null) right.get();
            System.out.println(this.value);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Root graph = new Root();
        int num = Integer.parseInt(br.readLine());
        graph.push(num);

        while(br.ready()){
            num = Integer.parseInt(br.readLine());
            graph.push(num);
        }
        graph.get();


    }
}