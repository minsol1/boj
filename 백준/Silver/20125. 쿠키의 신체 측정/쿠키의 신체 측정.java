
import java.io.*;
import java.util.*;

public class Main {

    public static char[][]arr;
    public static int x, y, hx,hy; // 심장, 허리끝 좌표
    public static int N;

    public static void la(){
        int c = 0;
        for(int i = y-1; i >=0; i--){
            if(arr[x][i] == '*') c++;
        }
        System.out.print(c+" ");
    }
    public static void ra(){
        int c = 0;
        for(int i = y+1; i <N; i++){
            if(arr[x][i] == '*') c++;
        }
        System.out.print(c+" ");

    }
    public static void h(){
        int c = 0;
        for(int i = x +1; i < N ; i++){
            if(arr[i][y] == '*') {
                c++;
                hx = i;
                hy = y;
            }
        }
        System.out.print(c+" ");
    }
    public static void lr(){
        int c = 0;
        for(int i = x +1; i < N ; i++){
            if(arr[i][hy-1] == '*') c++;
        }
        System.out.print(c+" ");
    }
    public static void rr(){
        int c = 0;
        for(int i = x + 1; i < N ; i++){
            if(arr[i][hy + 1] == '*') c++;
        }
        System.out.print(c+" ");
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char [N][N];

        for(int i =0; i< N; i++){
            String str = br.readLine();
            for(int j =0; j< N; j++ ){
                arr[i][j] = str.charAt(j);
            }
        }

        for(int i =0; i< N; i++){
            for(int j =0; j< N; j++ ){
                if(arr[i][j] == '*'){
                    x = i+1;
                    y = j;

                    System.out.print(x+1 +" ");
                    System.out.println(y+1);

                    la();
                    ra();
                    h();
                    lr();
                    rr();
                    return;
                }
            }
        }



    }
}
