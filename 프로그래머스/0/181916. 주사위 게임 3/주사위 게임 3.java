class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        // 4개 다 같을때
        if(a==b && b==c && c==d){
            return 1111*a;
        }
   
        // 4개 다 다를때
        if(a!=b && b!=c && c!=d && b!=d && d!=a && a!=c){
            a = Math.min(a,b);
            c = Math.min(c,d);
            
            return Math.min(a,c);
        }

        // 3개만 같을때
        if(a==b && b==c){
            return (10*a + d) * (10*a +d);
        }else if(a==b && b==d){
            return (10*a + c) * (10*a +c);
        }else if(b==c && c==d){
            return (10*b + a)*(10*b+a);
        }else if(a==c && c==d){
            return (10*a + b)*(10*a+b);
        }

        // 2개씩 같을때 3,3, 4,4
        if(a==b && c==d){
            return (a+c) * Math.abs(a-c);
        }else if(a==c && b==d){
            return (a+b) * Math.abs(a-b);
        }else if(a==d && b==c){
            return (a+b) * Math.abs(a-b);
        }
        
        // 2개 같고 나머지 다를때
        if(a==b){
            return c*d;
        }
        
        if(a==c){
            return b*d;
        }
        
        if(a==d){
            return b*c;
        }
        
        if(b==d){
            return a*c;
        }
        if(b==c){
            return a*d;
        }
     
        return a*b;
        
    }
}