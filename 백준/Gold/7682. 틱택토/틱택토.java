  
    import java.util.Scanner;

    public class Main {

        public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);
            String xo;
            char[][] map;
            while(!(xo =sc.nextLine()).equals("end") ){
                // map 만들기
                map = new char[3][3];
                for(int i=0; i<3; i++){
                    for(int j=0; j<3; j++){
                        map[i][j] = xo.charAt(i*3+j);
                    }
                }

                boolean isValid = false;
                boolean isEnd = false;
                int xcnt = 0;
                int ocnt = 0;
                //1. x. o 확인
                for(int i=0; i<3; i++){
                    for(int j=0; j<3; j++){
                        if(map[i][j] == 'X'){
                            xcnt++;
                        }else if(map[i][j]== 'O'){
                            ocnt++;
                        }
                    }
                }

                if(xcnt-1==ocnt || xcnt==ocnt) isValid = true;

                boolean owin = false, xwin = false;

                //2. 누가 이기나..
                if(isValid){

                    // 대각선
                    if(map[1][1]!='.' && (map[1][1]==map[0][2] && map[1][1]==map[2][0] || map[1][1]==map[0][0] && map[1][1]==map[2][2])){
                        if(map[1][1]=='X'){
                            xwin = true;
                        }else{
                            owin = true;
                        }
                    }

                        // 가로
                        for(int i=0; i<3; i++) {
                            if(map[i][0]=='.') continue;

                            if(map[i][0]==map[i][1] && map[i][0]==map[i][2]){

                                if(map[i][0]=='X'){
                                    xwin = true;
                                }else{
                                    owin = true;
                                }
                            }
                        }
                        // 세로
                        for(int i=0; i<3; i++) {
                            if(map[0][i]=='.') continue;

                            if(map[0][i]==map[1][i] && map[0][i]==map[2][i]){
                                if(map[0][i]=='X'){
                                    xwin = true;
                                }else{
                                    owin = true;
                                }
                            }
                        }




                    if(owin && xwin) isValid = false;
                    if(!owin && !xwin && xcnt!=5 && ocnt!=4){
                        isValid = false;
                    }

                }

                if(isValid){
                    if(owin && ocnt!=xcnt) isValid = false;
                    if(xwin && ocnt!=xcnt-1) isValid = false;
                }


                if(isValid){
                    System.out.println("valid");
                }else{
                    System.out.println("invalid");
                }

            }
        }


    }