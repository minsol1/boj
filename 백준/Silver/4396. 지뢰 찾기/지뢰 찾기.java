import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static char[][] arr;
    public static char[][] res;
    public static int[] dx = {0,1,0,-1,1,1,-1,-1};
    public static int[] dy = {1,0,-1,1,1,-1,-1,0};

    public static int count(int x, int y){
        int cnt =0;

        for(int d= 0;d<8;d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0|| nx>=N || ny <0 || ny>=N) continue;
            if(arr[nx][ny]=='*'){
                cnt++;
            }
        }
        return cnt;
    }

    public static void change(){
        for(int i =0;i<N;i++){
            for(int j =0;j<N;j++){
                if(arr[i][j]== '*'){
                    res[i][j] = '*';
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        res = new char[N][N];

        for(int i =0;i<N;i++){
            String str = br.readLine();
            for(int j =0;j<N;j++){
                arr[i][j] = str.charAt(j);
            }
        }

        for(int i =0;i<N;i++){
            String str = br.readLine();
            for(int j =0;j<N;j++){
                res[i][j] = str.charAt(j);
            }
        }

        for(int i =0;i<N;i++){
            for(int j =0;j<N;j++){
                if(res[i][j]=='x'){
                    if(arr[i][j]!='*'){
                        res[i][j] = Integer.toString(count(i,j)).charAt(0);
                    }
                    else change();
                }
            }
        }

        for(int i =0;i<N;i++){
            for(int j =0;j<N;j++){
                System.out.print(res[i][j]);
            }
            System.out.println("");
        }

    }
}
