
import java.io.*;
import java.util.*;

public class Main {

    public static char[][] arr;
    public static int N,M;
    public static char[][][] num = {
            {
                {'#','#','#'}
                ,{'#','.','#'}
                ,{'#','.','#'}
                ,{'#','.','#'}
                ,{'#','#','#'}
            }, // 0
            {
                    {'#','.'}
                    ,{'#','.'}
                    ,{'#','.'}
                    ,{'#','.'}
                    ,{'#','.'}
            },//1
            {
                    {'#','#','#'}
                    ,{'.','.','#'}
                    ,{'#','#','#'}
                    ,{'#','.','.'}
                    ,{'#','#','#'}
            },
            {
                    {'#','#','#'}
                    ,{'.','.','#'}
                    ,{'#','#','#'}
                    ,{'.','.','#'}
                    ,{'#','#','#'}
            },
            {
                    {'#','.','#'}
                    ,{'#','.','#'}
                    ,{'#','#','#'}
                    ,{'.','.','#'}
                    ,{'.','.','#'}
            },
            {
                    {'#','#','#'}
                    ,{'#','.','.'}
                    ,{'#','#','#'}
                    ,{'.','.','#'}
                    ,{'#','#','#'}
            },
            {
                    {'#','#','#'}
                    ,{'#','.','.'}
                    ,{'#','#','#'}
                    ,{'#','.','#'}
                    ,{'#','#','#'}
            },
            {
                    {'#','#','#'}
                    ,{'.','.','#'}
                    ,{'.','.','#'}
                    ,{'.','.','#'}
                    ,{'.','.','#'}
            },
            {
                    {'#','#','#'}
                    ,{'#','.','#'}
                    ,{'#','#','#'}
                    ,{'#','.','#'}
                    ,{'#','#','#'}
            },
            {
                    {'#','#','#'}
                    ,{'#','.','#'}
                    ,{'#','#','#'}
                    ,{'.','.','#'}
                    ,{'#','#','#'}
            }
            };

    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        N = 5;
        M = n/5;

        arr = new char[N][M];

        String str = br.readLine();
        for(int i =0; i<n; i++){

            arr[i/M][i%M] = str.charAt(i);
        }

        int idx = 0;
        while(idx < M){
            int c = 0;
            if(arr[0][idx] =='#'){

                for(int i = 0; i< 10 ; i++){

                    boolean f = true;
                    for(int k =0; k<5; k++){

                        if(i ==1){
                            if(arr[k][idx] !='#' ) f = false;
                            if(idx < M-1 && arr[k][idx+1] =='#' ) f = false;
                        }
                        else{
                            for(int j = 0; j <3; j++) {
                                if(idx + j >= M) {
                                    f = false;
                                    break;
                                }
                                if (arr[k][idx + j] != num[i][k][j]) {
                                    f = false;
                                }
                            }
                        }
                    }

                    if(f) {
                        c = i;
                        break;
                    }
                }
            }
            else {
                idx ++;
                continue;
            }

            System.out.print(c);
            if( c == 1) idx+=2;
            else idx += 3;
        }

    }
}
